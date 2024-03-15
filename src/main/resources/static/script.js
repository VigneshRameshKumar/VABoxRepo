var tossOver=false;
var button_Container= document.getElementById('button-container');


function TossDecision(toss) {
console.log("Hello there");
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
    document.getElementById("response2").innerText =result.batOrBowl;
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
    document.getElementById("response4").innerText =result.coumputerGuessVar;
    if(result.coumputerGuessVar==userInputNumber){
    document.getElementById("response5").innerText ="OUT";
    }
    else{
    document.getElementById("response5").innerText = result.currentTotalVar;
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
