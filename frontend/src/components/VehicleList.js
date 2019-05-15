import React from 'react';
import axios from 'axios';

export default class VehicleList extends React.Component {
    state = {
        vehicles: []
    }

    handleSubmit = (type = '') => {
        axios.get('/api/vehicles', {params: {type: type}})
            .then(res => {
                const vehicles = res.data;
                this.setState({vehicles})
            })
    }

    render() {
        return (
            <div>
                <button type="button" onClick={() => this.handleSubmit()}>All Vehicles</button>
                <button type="button" onClick={() => this.handleSubmit('BIKE')}>All Bikes</button>
                <button type="button" onClick={() => this.handleSubmit('CAR')}>All Cars</button>

                <ul>
                    {this.state.vehicles.map(vehicle => <li>{vehicle.name}</li>)}
                </ul>
            </div>
        )
    }
}
