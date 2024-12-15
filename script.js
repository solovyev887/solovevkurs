const showRegisterButton = document.getElementById('show-register');  
const showLoginButton = document.getElementById('show-login');  
const registerSection = document.getElementById('register');  
const loginSection = document.getElementById('login');  
const calculatorSection = document.getElementById('calculator');  
const goalSection = document.getElementById('goal-section');  

showRegisterButton.addEventListener('click', () => {  
    registerSection.classList.toggle('hidden');  
    calculatorSection.classList.add('hidden');  
    loginSection.classList.add('hidden');  
    goalSection.classList.add('hidden');  
});  

showLoginButton.addEventListener('click', () => {  
    loginSection.classList.toggle('hidden');  
    calculatorSection.classList.add('hidden');  
    registerSection.classList.add('hidden');  
    goalSection.classList.add('hidden');  
});  

// Калькулятор бюджета  
document.getElementById('calculate').addEventListener('click', () => {  
    const income = parseFloat(document.getElementById('income').value);  
    const expenses = parseFloat(document.getElementById('expenses').value);  
    const result = income - expenses;  
    const resultDisplay = document.getElementById('result');  
    
    resultDisplay.textContent = `Ваш оставшийся бюджет: ${result} руб.`;  
    resultDisplay.classList.remove('hidden');  
});  

// Подсчет накоплений  
document.getElementById('calculate-goal').addEventListener('click', () => {  
    const goal = parseFloat(document.getElementById('goal').value);  
    const savings = parseFloat(document.getElementById('savings').value);  
    const remaining = goal - savings;  
    const goalResultDisplay = document.getElementById('goal-result');  
    
    goalResultDisplay.textContent = `Вам осталось накопить: ${remaining} руб.`;  
    goalResultDisplay.classList.remove('hidden');  
});  
// Проверка авторизации пользователя  
const isUserLoggedIn = true; 
// Обработчик клика на кнопке "Начать подсчет"  
const startCountButton = document.querySelector('.button');  
startCountButton.addEventListener('click', () => {  
    if (isUserLoggedIn) {  
        window.location.href = 'calculator.html';  
    } else {  
        window.location.href = 'auth.html';  
    }  
});