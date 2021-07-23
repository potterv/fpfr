import React,{Component} from  'react'
import axios from 'axios'
class PostForm extends Component{

    constructor(props) {
        super(props);
        this.state={
            id:'',
            dateFact: '',
            dateAct: '',
            primechanie: '',
            protockol: ''
        }
    }

    changeHandler = (e) =>{
        this.setState({[e.target.name]: e.target.value})
    }



    submitHandler = e =>{
        e.preventDefault();
        console.log(this.state)
        axios.put('http://localhost:8080/apendixs',this.state, {
            method: 'PUT',
            headers: {
                'Access-Control-Allow-Origin': '*',
                'Content-Type': 'application/json',

                // withCredentials: true,
                mode: 'no-cors'
            }})
            .then(response =>{
                console.log(response)
            })
            .catch(error =>{
                console.log(error)
            })
    }

    render() {
        const { id, dateFact,dateAct, primechanie, protockol} = this.state;

        return(
            <div>
                <form onSubmit={this.submitHandler}>

                    <div>
                        <input type="text" name="id" value={id}
                               onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <input type="text" name="dateFact" value={dateFact}
                               onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <input type="text" name="dateAct" value={dateAct}
                               onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <input type="text" name="primechanie" value={primechanie}
                               onChange={this.changeHandler}/>
                    </div>
                    <div>
                        <input type="text" name="protockol" value={protockol}
                               onChange={this.changeHandler}/>
                    </div>
                    <button type="submit">Submit</button>
                </form>
            </div>
        )
    }
}

export default PostForm