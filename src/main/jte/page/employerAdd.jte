@template.layout.main(
content = @`
    <div class="company-form-container">
        <h2>Add New Employer</h2>
        <form action="/employer/add" method="post" class="company-form">
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" required class="form-control">
            </div>

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required class="form-control">
            </div>

            <div class="form-group">
                <label for="middleName">Middle Name:</label>
                <input type="text" id="middleName" name="middleName" class="form-control">
            </div>

            <div class="form-group">
                <label for="qualification">Qualification:</label>
                <input type="text" id="qualification" name="qualification" class="form-control">
            </div>

            <div class="form-group">
                <label for="activityType">Activity Type:</label>
                <input type="text" id="activityType" name="activityType" class="form-control">
            </div>

            <div class="form-group">
                <label for="otherInfo">Other Info:</label>
                <textarea id="otherInfo" name="otherInfo" class="form-control"></textarea>
            </div>

            <div class="form-group">
                <label for="expectedSalary">Expected Salary:</label>
                <input type="number" step="0.01" id="expectedSalary" name="expectedSalary" required class="form-control">
            </div>

            <button type="submit" class="btn-submit">Add Employer</button>
        </form>
    </div>
`,
headContent = @`
    <style>
        .company-form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .company-form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-control {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        textarea.form-control {
            min-height: 80px;
        }

        .btn-submit {
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }

        .btn-submit:hover {
            background-color: #45a049;
        }
    </style>
`
)
