import axios from 'axios'

const USERS_REST_API_URL = 'http://localhost:8080/apendixs';

class PutApendixService {

    PutApendix(){
          axios.put(USERS_REST_API_URL,this.state, {
            method: 'PUT',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',

                // withCredentials: true,
                mode: 'no-cors'
            }})
    }
}

export default new PutApendixService();