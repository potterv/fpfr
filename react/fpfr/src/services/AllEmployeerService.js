import axios from 'axios'

const USERS_REST_API_URL = 'http://10.92.7.41:8080/employeers';

class AllEmployeerService {

    getEmployeers(){
        return axios.get(USERS_REST_API_URL);
    }
}

export default new AllEmployeerService();