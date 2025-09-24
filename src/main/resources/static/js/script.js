document.addEventListener('DOMContentLoaded', () => {
    const display = document.getElementById('display');
    const buttons = document.getElementById('buttons');
    let currentInput = '';
    let firstOperand = null;
    let operator = null;

    function updateDisplay(text) {
        display.value = text || '0';
    }

    async function sendRequest(endpoint, first, second = null) {
        const body = { firstOperand: parseFloat(first), secondOperand: second !== null ? parseFloat(second) : null };
        try {
            const response = await fetch(`/app/${endpoint}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(body)
            });
            if (!response.ok) throw new Error(response.statusText);
            const data = await response.json();
            currentInput = data.result;
            updateDisplay(currentInput);
        } catch (err) {
            console.error("Error:", err);
            updateDisplay("Error");
        }
    }

    async function sendExpression(expression) {
        try {
            const response = await fetch(`/app/evaluate`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ expression })
            });
            if (!response.ok) throw new Error(response.statusText);
            const data = await response.json();
            currentInput = data.result;
            updateDisplay(currentInput);
        } catch (err) {
            console.error("Error:", err);
            updateDisplay("Error");
        }
    }

    display.addEventListener('input', (e) => {
        currentInput = e.target.value;
    });

    buttons.addEventListener('click', (event) => {
        if (!event.target.matches('button')) return;
        const value = event.target.value;

        switch (value) {
            case 'clear':
                currentInput = '';
                firstOperand = null;
                operator = null;
                updateDisplay('0');
                break;

            case 'calculate':
                if (firstOperand !== null && operator && currentInput !== '') {
                    sendRequest(operator, firstOperand, currentInput);
                    firstOperand = null;
                    operator = null;
                }
                else if (currentInput.trim() !== '') {
                    sendExpression(currentInput);
                }
                break;

            case 'plus-minus':
                if (currentInput) {
                    currentInput = currentInput.startsWith('-') ? currentInput.slice(1) : '-' + currentInput;
                    updateDisplay(currentInput);
                }
                break;

            case 'decimal':
                if (!currentInput.includes('.')) {
                    currentInput += currentInput === '' ? '0.' : '.';
                    updateDisplay(currentInput);
                }
                break;

            case 'add':
            case 'subtract':
            case 'multiply':
            case 'divide':
                if (currentInput === '') return;
                firstOperand = currentInput;
                operator = value;
                currentInput = '';
                break;

            default:
                currentInput += value;
                updateDisplay(currentInput);
                break;
        }
    });
});
