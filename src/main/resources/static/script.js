function TossDecision(toss) {


    // Basic validation
    if (toss.trim() === '' ) {
        alert('Please fill in all fields.');
        return;
    }



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
        document.getElementById("response").innerText = result.tossResult;
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById("response").innerText = 'An error occurred.';
    });
}