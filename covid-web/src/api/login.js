import {postAxios} from '../lib/requestConfig'

export const login=(username,password)=>{
    return postAxios('/login',{
        username:username,
        password:password
    })
}