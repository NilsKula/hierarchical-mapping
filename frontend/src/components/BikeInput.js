import React from 'react';
import axios from 'axios';

export default class BikeInput extends React.Component {
    state = {
        name: '',
        color: '',
    }

    handleChange = event => {
        this.setState({[event.target.name]: event.target.value})
    }

    handleSubmit = event => {
        event.preventDefault();
        const {name, color} = this.state;

        axios.post('/api/bike',
            {name, color})
            .then(res => {
                console.log(res);
                console.log(res.data)
            })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Name:
                        <input type="text" name="name" onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <label>
                        Color:
                        <input type="text" name="color" onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <button type="submit">Add</button>
                </form>
            </div>
        )
    }
}