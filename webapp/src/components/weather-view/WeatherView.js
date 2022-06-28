import React from 'react';
import { useParams } from 'react-router-dom';
import { getCityForecast } from '../../services/WeatherService';
import WeatherCard from '../home/WeatherCard';

function withParams(Component) {
    return props => <Component {...props} params={useParams()} />
}

class WeatherView extends React.Component {

    constructor() {
        super();
        this.state = {
            weatherData: null
        };
    }

    componentDidMount() {
        const response = getCityForecast(this.props.params.cityname).then(x => {
            this.setState({weatherData: x.data});
        });  
    }

    render() {
        return this.state?.weatherData 
        ? (<WeatherCard data={this.state.weatherData} cityname={this.props.params.cityname} showFavButton={true} />) 
        : (<div></div>);
    }
}

export default withParams(WeatherView);

