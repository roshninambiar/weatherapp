import { Button, Container } from "react-bootstrap";
import { Card } from "react-bootstrap";
import { getCityForecast, getCityList, getFavoriteCity } from '../../services/WeatherService';
import React from "react";
import WeatherCard from "./WeatherCard";


class Home extends React.Component {

    constructor() {
        super();
        this.state = {
            weatherData: undefined,
            cityData: undefined,
            cityCards: undefined
        };
    }

    componentDidMount() {
        const favouriteCity = getFavoriteCity();
        
        if (favouriteCity) {
            const response = getCityForecast(favouriteCity).then(x => {
                this.setState({ weatherData: x.data, favouriteCity });
            });
        }

        const cityData = getCityList().then(x => {
            this.setState({ cityData: x.data });
        });

    }

    getCityCards = () => this.state.cityData?.map(city => {
        return (
            <div class="col-md-3 col-sm-12 mb-5">
                <div class="card h-100"><img alt="Card image cap" class="h-100 card-img-top img-fluid" src={`/cities/${city.toLowerCase()}.jpeg`} />
                    <div class="card-block" className="d-grid gap-2">
                        <Button variant="outline-primary" href={`weather/${city}`}>{city}</Button>{' '}
                    </div>
                </div>
            </div>
        )
    });

    render() {
        return (
            <>
                {this.state?.weatherData && (<WeatherCard data={this.state.weatherData} cityname={this.state.favouriteCity} showFavButton={false} />)}

                <div>
                    <div>
                        <Card style={{ border: "none" }}>
                            <Card.Body>
                                <Container>
                                    <div class="row justify-content-center " style={{ height: "250px" }}>
                                        {this.getCityCards()}
                                    </div>
                                </Container>
                            </Card.Body>
                        </Card>
                    </div>
                </div>
            </>
        );
    }


}

export default Home;