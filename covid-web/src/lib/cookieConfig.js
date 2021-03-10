import Cookies from 'js-cookie'
import config from '@/config'
const {cookieExpires} = config
export const TOKEN_KEY='covid'
export default{
    setToken:(token)=>{
        Cookies.set(TOKEN_KEY,token,{
            expires:cookieExpires || 1  //记录cookie过期时间：1天
        })
    },
    getToken:()=>{
        const token=Cookies.get(TOKEN_KEY)
        return token?token:null
    },
    clearToken:()=>{
        Cookies.remove(TOKEN_KEY)
    }
}