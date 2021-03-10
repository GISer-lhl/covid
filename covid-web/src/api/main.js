import {postAxios} from '../lib/requestConfig'

export const getConfirmNum=()=>{
    return postAxios('/users/selectAll')
}