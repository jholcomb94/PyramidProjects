import React, { Component } from 'react';
import {Link} from 'react-router-dom'

class WelcomePage extends Component{
    render() {
        return(
            <div className = "welcome">
                <h1>Welcome to tic tac toe</h1>
                <Link to="/gamePage"><button>PLAY</button></Link>
            </div>
        )
    }
}
export default WelcomePage