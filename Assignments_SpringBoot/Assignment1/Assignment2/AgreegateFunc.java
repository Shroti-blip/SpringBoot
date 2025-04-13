/*
*
*


### 1️⃣ **Average salary of employees in the "Finance" department**:
```sql
SELECT AVG(salary) AS average_salary
FROM employees
WHERE department = 'Finance';
```

---

### 2️⃣ **Highest and lowest salary among all employees**:
```sql
SELECT
    MAX(salary) AS highest_salary,
    MIN(salary) AS lowest_salary
FROM employees;
```

---

### 3️⃣ **List departments along with their total salary expenses**:
```sql
SELECT department, SUM(salary) AS total_salary_expense
FROM employees
GROUP BY department;
```

---

### 4️⃣ **Find the number of employees hired in each year**:
```sql
SELECT EXTRACT(YEAR FROM hire_date) AS hire_year, COUNT(*) AS employee_count
FROM employees
GROUP BY hire_year
ORDER BY hire_year;
```

### ✅ 1️⃣ **Find the total salary paid to all employees**:
```sql
SELECT SUM(salary) AS total_salary
FROM employees;
```
🧾 *This gives you one number — the total of all salaries in the table.*

---

### ✅ 2️⃣ **Count the number of employees in each department**:
```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
GROUP BY department;
```
🧾 *This will list each department with the number of employees in it.*

*
* */