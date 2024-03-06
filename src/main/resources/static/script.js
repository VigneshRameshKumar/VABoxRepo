function TossDecision(toss) {

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
        }
        if(result.tossResult==='Toss won'){
        a_Container.style.display = 'block';
        }
        else{
         a_Container.style.display = 'none';
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

    })
    .catch(error => {
            console.error('Error:', error);
            document.getElementById("response2").innerText = 'An error occurred.';
        });
}
