import { Button, Container } from "react-bootstrap";
import { setFavoriteCity } from "../../services/WeatherService";

function WeatherCard(props) {
    //console.log('weather card : ' + props?.apiResponse?.city_name);
    const res = props.data;
    const cityname = props.cityname;

    console.log(props.data);

    //     const content = props.posts.map((post) =>
    //     <div key={post.id}>
    //       <h3>{post.title}</h3>
    //       <p>{post.content}</p>
    //     </div>
    //   );
    const weeklyForecast = res.data.map((day) =>
        <div class="flex-column">
            <p class="medium"><strong>{day.min_temp}°C</strong></p>
            <p class="medium"><strong>{day.max_temp}°C</strong></p>
            <i class="fas fa-sun fa-2x mb-3" style={{ color: "#ddd" }}></i>
            <p class="small"><strong>{day.datetime}</strong></p>

        </div>

    );

    return (
        <Container>
            <section class="vh-25" style={{ backgroundColor: "#C1CFEA;" }}>
                <div class="container py-5 h-100">

                    <div class="row d-flex justify-content-center align-items-center h-25" style={{ color: "#282828" }}>
                        <div class="col-md-9 col-lg-9 col-xl-9">
                            <div class="card mb-4 gradient-custom .bg-info.bg-gradient" style={{ borderRadius: "25px" }}>
                                <div class="card-body p-4">

                                    <div class="d-flex justify-content-between mb-4 pb-2">
                                        <div>
                                            <h2 class="display-2"><strong>{res.data[0].temp}°C</strong></h2>
                                            {/* <p class="text-muted mb-0">{props?.data?.city_name}, {props?.data?.country_code}</p> */}
                                            <p class="text-muted mb-0">{cityname}, {res.country_code}</p>
                                        </div>
                                        <div>
                                            <img src={`/icons/${res.data[0].weather.icon}.png`} width="150px" />
                                        </div>
                                    </div>




                                </div>
                            </div>

                            <div class="card mb-4" style={{ borderRadius: "25px" }}>
                                <div class="card-body p-4">
                                    <div class="carousel-inner">
                                        <div class="carousel-item active">
                                            <div class="d-flex justify-content-around text-center mb-4 pb-3 pt-2">
                                                {weeklyForecast}
                                            </div>
                                        </div>
                                    </div>


                                </div>
                            </div>

                            {/* <div class="card" style={{ borderRadius: "25px" }}>
                                <div class="card-body p-4">

                                    <div id="demo3" class="carousel slide" data-ride="carousel">
                                        <ul class="carousel-indicators mb-0">
                                            <li data-target="#demo3" data-slide-to="0"></li>
                                            <li data-target="#demo3" data-slide-to="1"></li>
                                            <li data-target="#demo3" data-slide-to="2" class="active"></li>
                                        </ul>
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <div class="d-flex justify-content-around text-center mb-4 pb-3 pt-2">
                                                    <div class="flex-column">
                                                        <p class="small"><strong>21°C</strong></p>
                                                        <i class="fas fa-sun fa-2x mb-3" style={{ color: "#ddd" }}></i>
                                                        <p class="mb-0"><strong>Mon</strong></p>
                                                    </div>
                                                    <div class="flex-column">
                                                        <p class="small"><strong>20°C</strong></p>
                                                        <i class="fas fa-sun fa-2x mb-3" style={{ color: "#ddd" }}></i>
                                                        <p class="mb-0"><strong>Tue</strong></p>
                                                    </div>
                                                    <div class="flex-column">
                                                        <p class="small"><strong>16°C</strong></p>
                                                        <i class="fas fa-cloud fa-2x mb-3" style={{ color: "#ddd" }}></i>
                                                        <p class="mb-0"><strong>Wed</strong></p>
                                                    </div>
                                                    <div class="flex-column">
                                                        <p class="small"><strong>17°C</strong></p>
                                                        <i class="fas fa-cloud fa-2x mb-3" style={{ color: "#ddd" }}></i>
                                                        <p class="mb-0"><strong>Thu</strong></p>
                                                    </div>
                                                    <div class="flex-column">
                                                        <p class="small"><strong>18°C</strong></p>
                                                        <i class="fas fa-cloud-showers-heavy fa-2x mb-3" style={{ color: "#ddd" }}></i>
                                                        <p class="mb-0"><strong>Fri</strong></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div> */}

                            {props.showFavButton && (<Button className="btn-secondary mt-3" onClick={() => setFavoriteCity(cityname)}>Pin as Favourite</Button>)}

                        </div>
                    </div>

                </div>
            </section>
        </Container>
    )
}

export default WeatherCard;