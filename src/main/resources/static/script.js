var tossOver=false;
var button_Container= document.getElementById('button-container');


function TossDecision(toss) {
console.log("Hi");
    // Basic validation
    if (toss.trim() === '' ) {
        alert('Please fill in all fields.');
        return;
    }
    var a_Container= document.getElementById('a');

    // Send data to Spring Boot backend
    fetch('/toss', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(toss),
    })
    .then(response => response.json())
    .then(result => {
        document.getElementById("b").innerText=result.actualToss;
        document.getElementById("response").innerText = result.tossResult;
        if(result.comWonTossFlag){
        document.getElementById("response3").innerText=result.computerChoiceVar;
        console.log("computer won toss");
        tossOver=true;
        }
        if(result.tossResult==='Toss won'){
        a_Container.style.display = 'block';
        console.log("player won toss");
        }
        else{
         a_Container.style.display = 'none';
        }
        if(tossOver){
        button_Container.style.display='block';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById("response").innerText = 'An error occurred.';
    });

}


function playerChoice(batString){

    fetch('/playerChoosingEndpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(batString),
    })
    .then(response => response.json())
    .then(result => {
    document.getElementById("response2").innerText =(result.batOrBowl ==='first'?"Player choose to Bat first":"Player choose to Bowl first");  // for debugging output (first or second)
    button_Container.style.display='block';
    })
    .catch(error => {
            console.error('Error:', error);
            document.getElementById("response2").innerText = 'An error occurred.';
        });
}



function sendValueToEndpoint(userInputNumber){
console.log("send");
    fetch('/getPlayerInputEndpoint', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userInputNumber),
    })
    .then(response => response.json())
    .then(result => {
    document.getElementById("response4").innerText ="comp puts : " + result.coumputerGuessVar;
    document.getElementById("response7").innerText = "Player score : " + result.playerScore;
    document.getElementById("response8").innerText = "Computer score : " + result.computerScore;
    if(result.coumputerGuessVar==userInputNumber){
    document.getElementById("response5").innerText ="OUT";
    document.getElementById("target").innerText = result.targetScoreVar;
    }
    else{
    document.getElementById("response5").innerText ="Score : " + result.currentTotalVar;
    }
    if(result.matchOverVar){
    document.getElementById("response6").innerText = result.matchResult;

    }
    })
    .catch(error => {
            console.error('Error:', error);
            document.getElementById("response4").innerText = 'An error occurred.';
        });
}



document.addEventListener('DOMContentLoaded', function () {
            // Detect page reload or navigation
            window.addEventListener('beforeunload', function () {
                // Send fetch request to reset global object
                fetch('/resetGlobalObject', {
                    method: 'POST'
                })
                .then(function (response) {
                    if (response.ok) {
                        console.log('Global object reset successfully');
                    } else {
                        console.error('Error resetting global object');
                    }
                })
                .catch(function (error) {
                    console.error('Error resetting global object:', error);
                });
            });
        });
