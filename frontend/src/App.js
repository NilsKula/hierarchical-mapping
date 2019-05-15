import React, {Component} from 'react';
import './App.css';
import BikeInput from './components/BikeInput'
import CarInput from './components/CarInput'
import VehicleList from './components/VehicleList'

class App extends Component {
    render() {
        return (

            <div>
                <h1>Vehicles</h1>
                <div>
                    <h3>Add bike</h3>
                    <BikeInput/>
                </div>
                <div>
                    <h3>Add car</h3>
                    <CarInput/>
                </div>
                <h2>List of Vehicles</h2>
                <VehicleList/>
                <div>

                </div>
            </div>
        );
    }
}

export default App;
