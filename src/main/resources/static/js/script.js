document.addEventListener('DOMContentLoaded', () => {
    const display = document.getElementById('display');
    const buttons = document.getElementById('buttons');
    let currentInput = '';
    let firstOperand = null;
    let operator = null;

    function updateDisplay(text) {
        display.textContent = text || '0';
    }

    async function sendRequest(endpoint, first, second = null) {
        const body = { firstOperand: parseFloat(first), secondOperand: second ? parseFloat(second) : null };

        const response = await fetch(`/api/${endpoint}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(body)
        });

        if (!response.ok) {
            console.error("Error response:", response.statusText);
            return;
        }

        const data = await response.json();
        currentInput = data.result;
        updateDisplay(currentInput);
    }

    buttons.addEventListener('click', (event) => {
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
            if (firstOperand !== null && operator && currentInput !== '') {
                sendRequest(operator, firstOperand, currentInput);
                firstOperand = null;
                operator = null;
            }
        }
        else if (value === 'decimal') {
            if (!currentInput.includes('.')) {
                currentInput += currentInput === '' ? '0.' : '.';
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
            sendRequest(value, currentInput);
        }
        else {
            currentInput += value;
            updateDisplay(currentInput);
        }
    });
});