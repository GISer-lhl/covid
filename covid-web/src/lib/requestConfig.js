import Axios from 'axios'
import QS from 'qs'; // 引入qs模块，用来序列化post类型的数据，不序列化后台拿不到传入的参数
// vant的toast提示框组件，大家可根据自己的ui组件更改。
import { Toast } from 'vant'
import config from '@/config'
import cookie from '@/lib/cookieConfig'

export const baseUrl=config.baseUrl.apiUrl
export const websocketUrl=config.baseUrl.webSocketUrl

let axios=Axios.create({
    //baseURL:baseUrl,
    baseURL:'http://127.0.0.1:8081/',
    timeout:300000,   //毫秒
    headers:{
        'Content-Type':'application/json;charset=utf-8'
    }
})
axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF-8';
//定义请求拦截器
axios.interceptors.request.use(    
    function(config){
        let token = cookie.getToken()
        // 在发送请求之前将token加入请求头
        if(token){
            //config.headers['x-access-token']=token
            //下面将token放在header中
            token && (config.headers.Authorization = token);
        }
        //console.log()
        return config
    },
    function(error){
        // 对请求错误做些什么
        Toast({
            message:'请求数据错误：100001'
        })
        return Promise.reject(error);
    }
)
//定义请求完成响应拦截器
axios.interceptors.response.use(
    response=>{
        if (res.config.responseType === 'blob') {
            let isReturnJson = res.headers && res.headers['content-type'] && res.headers['content-type'].indexOf("json") > -1;
            //后端返回错误信息
            if (isReturnJson) {
                let reader = new FileReader()
                reader.onload = function (event) {
                let content = reader.result
                let parseRes = JSON.parse(content) // 错误信息
                return validateResponseCode({
                    data: parseRes
                });
                }
                reader.readAsText(res.data);
                return true
            } else {
                //下载文件
                download(res);
            }
        } else {
            if (response.status === 200) {            
                //正常json请求
                return validateResponseCode(res);        
            }else{
                return Promise.reject(response)
            }        
        }
    },
    error=>{
        // if (error.response.status) {
        //     switch(error.response.status){
        //         // 401: 未登录
        //         // 未登录则跳转登录页面，并携带当前页面的路径
        //         // 在登录成功后返回当前页面，这一步需要在登录页操作
        //         case 401:
        //             router.replace({                        
        //                 path: '/login',                        
        //                 query: { 
        //                     redirect: router.currentRoute.fullPath 
        //                 }
        //             });
        //             break;
        //         // 403 token过期
        //         // 登录过期对用户进行提示
        //         // 清除本地token和清空vuex中token对象
        //         // 跳转登录页面                
        //         case 403:
        //              Toast({
        //                 message: '登录过期，请重新登录',
        //                 duration: 1000,
        //                 forbidClick: true
        //             });
        //             // 清除token
        //             localStorage.removeItem('token');
        //             store.commit('loginSuccess', null);
        //             // 跳转登录页面，并将要浏览的页面fullPath传过去，登录成功后跳转需要访问的页面 
        //             setTimeout(() => {                        
        //                 router.replace({                            
        //                     path: '/login',                            
        //                     query: { 
        //                         redirect: router.currentRoute.fullPath 
        //                     }                        
        //                 });                    
        //             }, 1000);                    
        //             break; 

        //         // 404请求不存在
        //         case 404:
        //             Toast({
        //                 message: '网络请求不存在',
        //                 duration: 1500,
        //                 forbidClick: true
        //             });
        //             break;
        //         // 其他错误，直接抛出错误提示
        //         default:
        //             Toast({
        //                 message: error.response.data.message,
        //                 duration: 1500,
        //                 forbidClick: true
        //             });
        //     }
        // }
        return Promise.reject(error);
    }
)
//验证响应码
function validateResponseCode(res){
    let{data}=res
    // if(data&&data.code&&data.code!==1){
    //     if(data.code===1001){
    //         cookie.clearToken();
    //         localStorage.clear();
    //         //跳转登录页面
    //         //window.location.href=window.location.pathname+'#/login'
    //         Toast({
    //             message:'登录过期，请先登录'
    //         })
    //         return
    //     }else{
    //         Toast({
    //             message:data.msg
    //         })
    //         return Promise.reject(res)
    //     }
    // }
    return Promise.resolve(res)
}

export const postAxios=(url,data)=>{
    if(data){
        return axios.post(url,QS.stringify(data))
    } else {
        console.log('1234')
        return axios.post(url)
    }
}

export const postFileUploadAxios=(url,data)=>{
    return axios.post(url,QS.stringify(data),{
        headers:{
            'Content-Type':'multipart/form-data'
        }
    })
}

export const getDownloadAxios=(url)=>{
    return axios.get(url,{
        responseType:'blob'
    })
}

export const postDownloadAxios=(url,data)=>{
    return axios.post(url,QS.stringify(data),{
        responseType:'blob'
    })
}

export const getAxios=(url,data)=>{
    return axios.get(url,{
        params:data
    })
}

function download (res) {
    let reader = new FileReader();
    let data = res.data;
    reader.onload = e => {
      if (e.target.result.indexOf('Result') != -1 && JSON.parse(e.target.result).Result == false) {
        // 进行错误处理
      } else {
        let fileName = "download";
        let contentDisposition = res.headers['Content-Disposition'];
        contentDisposition = contentDisposition ? contentDisposition : res.headers['content-disposition'];
        if (contentDisposition) {
          fileName = window.decodeURI(contentDisposition.split('=')[1], "UTF-8");
        }
        executeDownload(data, fileName);
      }
    };
    reader.readAsText(data);
  }
  
  //  模拟点击a 标签进行下载
  function executeDownload (data, fileName) {
    if (!data) {
      return
    }
    let url = window.URL.createObjectURL(new Blob([data]));
    let link = document.createElement('a');
    link.style.display = 'none';
    link.href = url;
    link.setAttribute('download', fileName);
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  }