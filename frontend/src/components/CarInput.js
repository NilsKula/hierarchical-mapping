import React from 'react';
import axios from 'axios';

export default class CarInput extends React.Component {
    state = {
        name: '',
        year: '',
    }

    handleChange = event => {
        this.setState({[event.target.name]: event.target.value})
    }

    handleSubmit = event => {
        event.preventDefault();
        const {name, year} = this.state;

        axios.post('/api/car',
            {name, year})
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
                        Year:
                        <input type="text" name="year" onChange={this.handleChange}/>
                    </label>
                    <br/>
                    <button type="submit">Add</button>
                </form>
            </div>
        )
    }
}