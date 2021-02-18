import React, { Component } from 'react';

class GamePage extends Component{
    constructor(props) {
        super(props);
        this.state = {
            turn: "X",
            gameOver: false,
            winner: "",
            board: Array(9).fill(''),
            moves: 0
        }
    }

    handleClick(arg)
    {
        if(!this.state.gameOver)
        {
            if(arg.innerText == "")
            {
                arg.innerText = this.state.turn;
                this.state.board[arg.id-1] = this.state.turn;
                this.setState({
                    moves: this.state.moves+1
                })
                if(this.state.turn == "X")
                {
                    this.setState({
                        turn: "O"
                    })
                }
                else{
                    this.setState({
                        turn: "X"
                    })
                }
            }
            var winner = this.checkWinner();
            console.log(winner)
            if(winner == "X")
            {
                console.log("X is the winner")
                this.setState({
                    gameOver: true
                })
            }
            if(winner == "O")
            {
                console.log("O is the winner")
                this.setState({
                    gameOver: true
                })
            }
        }

      
    }
    render() {
        return(
            <div className = "gamePage">
                <h1>TIC TAC TOE</h1>
                <table className = 'game' onClick={(e) => this.handleClick(e.target)}>
                    <tr>
                        <td className = "Square">  <button id = "1" className = "button"></button></td>
                        <td className = "Square">  <button id = "2" className = "button"></button></td>
                        <td className = "Square">  <button id = "3"className = "button"></button></td>
                    </tr>
                    <tr>
                        <td className = "Square">  <button id = "4"  className = "button"></button></td>
                        <td className = "Square">  <button id = "5"  className = "button"></button></td>
                        <td className = "Square">  <button id = "6"  className = "button"></button></td>
                    </tr>
                    <tr>
                        <td className = "Square">  <button id = "7"  className = "button"></button></td>
                        <td className = "Square">  <button id = "8"  className = "button"></button></td>
                        <td className = "Square">  <button id = "9"  className = "button"></button></td>
                    </tr>
                </table>
            </div>
        )
    }
    checkWinner(){
        console.log("winner method")
        var board = this.state.board;
        console.log(board)
        if(!board[0] == "" && !board[3] == "" && !board[6] == "")
        {
            if(board[0] == board[3] && board[3] == board[6])
            {
                return board[0];             
            }
        }
        if(!board[0] == "" && !board[1] == "" && !board[2] == "")
        {
            if(board[0] == board[1] && board[1] == board[2])
            {
                return board[0];             
            }
        }
        if(!board[1] == "" && !board[4] == "" && !board[7] == "")
        {
            if(board[1] == board[4] && board[1] == board[7])
            {
                return board[1];             
            }
        }
        if(!board[2] == "" && !board[5] == "" && !board[8] == "")
        {
            if(board[2] == board[5] && board[5] == board[8])
            {
                return board[2];             
            }
        }
        if(!board[0] == "" && !board[4] == "" && !board[8] == "")
        {
            if(board[0] == board[4] && board[4] == board[8])
            {
                return board[0];             
            }
        }
        if(!board[2] == "" && !board[4] == "" && !board[6] == "")
        {
            if(board[2] == board[4] && board[4] == board[6])
            {
                return board[2];             
            }
        }
        if(!board[3] == "" && !board[4] == "" && !board[5] == "")
        {
            if(board[3] == board[4] && board[3] == board[5])
            {
                return board[3];             
            }
        }
        if(!board[6] == "" && !board[7] == "" && !board[8] == "")
        {
            if(board[6] == board[7] && board[6] == board[8])
            {
                return board[6];             
            }
        }
        
    }
}
export default GamePage