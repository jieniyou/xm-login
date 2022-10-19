import request from '@/utils/request/index';

export function login(loginForm){
    return request.post("/sys-user/login",loginForm)
}

export function register(ruleForm){
    return request.post("/sys-user/register",ruleForm)
}