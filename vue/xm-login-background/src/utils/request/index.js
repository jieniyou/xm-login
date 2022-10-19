import axios from 'axios'

axios.defaults.baseURL='http://47.93.7.123:81/admin'
axios.defaults.timeout=10000

export default axios