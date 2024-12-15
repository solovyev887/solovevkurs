  const storedGoalName = localStorage.getItem('goalName');  
    const storedGoalAmount = localStorage.getItem('goalAmount');  
    const storedCurrentAmount = localStorage.getItem('currentAmount');  

    let goalAmount = storedGoalAmount ? parseFloat(storedGoalAmount) : 0;  
    let currentAmount = storedCurrentAmount ? parseFloat(storedCurrentAmount) : 0;  

    // 初始化页面  
    if (storedGoalName) {  
        document.getElementById('goalName').value = storedGoalName;  
        document.getElementById('goalNameDisplay').innerText = storedGoalName;  
    }  

    if (goalAmount > 0) {  
        document.getElementById('goalAmount').value = goalAmount;  
        document.getElementById('goalTotalAmount').innerText = `Цель: ${goalAmount}`;  
        updateProgress();  
    }  

    // 为添加资金按钮添加事件监听器  
    document.getElementById('addButton').onclick = function () {  
        const addAmount = parseFloat(document.getElementById('addAmount').value);  

        if (!isNaN(addAmount) && addAmount > 0) {  
            currentAmount += addAmount; // 更新当前金额  
            updateProgress(); // 更新进度条  
        }  
    };  

    // 目标金额变更时更新 localStorage  
    document.getElementById('goalAmount').onchange = function () {  
        goalAmount = parseFloat(this.value);  
        localStorage.setItem('goalAmount', goalAmount);  
        document.getElementById('goalTotalAmount').innerText = `Цель: ${goalAmount}`;  
        updateProgress();  
    };  

    // 目标名称变更时更新 localStorage  
    document.getElementById('goalName').onchange = function () {  
        const goalName = this.value;  
        document.getElementById('goalNameDisplay').innerText = goalName;  
        localStorage.setItem('goalName', goalName);  
    };  

    function updateProgress() {  
        const progressPercentage = Math.min((currentAmount / goalAmount) * 100, 100); // 计算进度百分比  
        document.getElementById('goalProgressBar').style.width = progressPercentage + '%'; // 更新进度条宽度  
        document.getElementById('goalCurrentAmount').innerText = `Текущая сумма: ${currentAmount}`;  

        // 更新 localStorage 中的当前金额  
        localStorage.setItem('currentAmount', currentAmount);  
    }  
    