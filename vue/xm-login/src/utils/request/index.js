import axios from 'axios';
// qs 是一个增加了一些安全性的查询字符串解析和序列化字符串的库。
import QS from 'qs';
// 设置axios的默认请求地址
axios.defaults.baseURL = 'http://localhost:8080/'
// 环境切换的话可以使用
// if (process.env.NODE_ENV == 'development') {    
//     axios.defaults.baseURL = 'https://www.baidu.com';} 
// else if (process.env.NODE_ENV == 'debug') {    
//     axios.defaults.baseURL = 'https://www.ceshi.com';
// } 
// else if (process.env.NODE_ENV == 'production') {    
//     axios.defaults.baseURL = 'https://www.production.com';
// }
// 设置默认的请求超时时间
axios.defaults.timeout = 10000

// 请求头设置
// application/x-wwww-form-urlencoded;charset=UTF-8
axios.defaults.headers.post['Content-Type']='application/x-wwww-form-urlencoded;charset=UTF-8'

export default axios