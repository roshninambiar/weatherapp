import { render } from "@testing-library/react";
import { Button } from "react-bootstrap";

function CityCard(props) {
    render(
        <div class="col-md-3">
            <div class="card h-100"><img alt="Card image cap" class="h-100 card-img-top img-fluid" src={data} />
                <div class="card-block" className="d-grid gap-2">
                    <Button variant="outline-primary">
                        {props.cityname}
                        <input type="checkbox" value={props.cityname} name="favourite" />
                    </Button>{' '}
                </div>
            </div>
        </div>
    )
}

export default CityCard;