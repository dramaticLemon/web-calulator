document.addEventListener('DOMContentLoaded', function () {
    const display = document.getElementById('display');
    const buttons = document.getElementById('buttons');
    let currentInput = '';
    let firstOperand = null;
    let operator = null;

    function updateDisplay(text) {
        display.textContent = text || '0';
    }

    buttons.addEventListener('click', function (event) {
        if (!event.target.matches('button')) return;

        const value = event.target.value;

        if (value === 'clear') {
            currentInput = '';
            firstOperand = null;
            operator = null;
            updateDisplay('0');
        }
        else if (['add', 'subtract', 'multiply', 'divide'].includes(value)) {
            if (currentInput === '') return;
            firstOperand = currentInput;
            operator = value;
            currentInput = '';
        }
        else if (value === 'calculate') {
            if (firstOperand !== null && operator !== null && currentInput !== '') {
                sendCalculation(firstOperand, currentInput, operator);
                firstOperand = null;
                operator = null;
            }
        }
        else if (value === 'decimal') {
            if (!currentInput.includes('.')) {
                currentInput += (currentInput === '' ? '0.' : '.');
                updateDisplay(currentInput);
            }
        }
        else if (value === 'plus-minus') {
            if (currentInput) {
                currentInput = currentInput.startsWith('-') ? currentInput.slice(1) : '-' + currentInput;
                updateDisplay(currentInput);
            }
        }
        else if (['sqrt', 'percent'].includes(value)) {
            if (currentInput === '') return;
            sendCalculation(currentInput, 0, value);
        }
        else {
            currentInput += value;
            updateDisplay(currentInput);
        }
    });

    function sendCalculation(first, second, operator) {
        fetch('/calculate', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: `firstOperand=${first}&secondOperand=${second}&operator=${operator}`
        })
        .then(response => response.text())
        .then(html => {
            const parser = new DOMParser();
            const doc = parser.parseFromString(html, 'text/html');
            const result = doc.getElementById('display').textContent;
            currentInput = result;
            updateDisplay(result);
        })
    }
});
