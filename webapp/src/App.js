import './App.css';
import { Navbar, Nav, Container } from 'react-bootstrap';
import Card from 'react-bootstrap/Card'
import Home from './components/home/Home';
import { Route, Routes } from 'react-router-dom';
import WeatherView from './components/weather-view/WeatherView';
import { getFavoriteCity } from './services/WeatherService';

function App() {
  const favouriteCity = getFavoriteCity();

  return (
    <div className="App">
      <Navbar bg="dark" variant="dark">
        <Container>
          <Navbar.Brand href="/">Weather Forecast</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Home</Nav.Link>
            <Nav.Link href={`/weather/${favouriteCity}`}>Favourite</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Routes>
        <Route exact path='/' element={<Home/>}/>
        <Route exact path='/weather/:cityname' element={<WeatherView/>}/>
      </Routes>
     
    </div>
  
  );
}

export default App;
