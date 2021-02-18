import React, {Component} from 'react';
import WelcomePage from './WelcomePage';
import GamePage from './GamePage';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

class RouterComponent extends Component {
    render(){
        return(
            <Router>
                <>
                    <Switch>
                        <Route path="/" exact component={WelcomePage} />
                        <Route path="/gamePage" exact component={GamePage} />
                    </Switch>
                </>
            </Router>
        )
    }
}
export default RouterComponent