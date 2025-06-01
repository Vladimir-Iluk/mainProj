@import com.iluk.git.mainProj.data.Entitys.Employer
@param Employer empl

@template.layout.main(
content = @`
    <div class="employer-form-container">
        <h2>Edit Employer</h2>
        <form action="/employer/edit" method="post" class="employer-form">
            <input type="hidden" name="id" value="${empl.getEmployerId()}">

            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${empl.getEmployerId()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${empl.getFirstName()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="middleName">Middle Name:</label>
                <input type="text" id="middleName" name="middleName" value="${empl.getMiddleName()}" class="form-control">
            </div>

            <div class="form-group">
                <label for="qualification">Qualification:</label>
                <input type="text" id="qualification" name="qualification" value="${empl.getQualification()}" class="form-control">
            </div>

            <div class="form-group">
                <label for="activityType">Activity Type:</label>
                <input type="text" id="activityType" name="activityType" value="${empl.getActivityType()}" class="form-control">
            </div>

            <div class="form-group">
                <label for="otherInfo">Other Info:</label>
                <textarea id="otherInfo" name="otherInfo" class="form-control">${empl.getOtherInfo()}</textarea>
            </div>

            <div class="form-group">
                <label for="expectedSalary">Expected Salary:</label>
                <input type="number" step="0.01" id="expectedSalary" name="expectedSalary" value="${empl.getExpectedSalary()}" required class="form-control">
            </div>

            <button type="submit" class="btn-submit">Update Employer</button>
        </form>
    </div>
`,
headContent = @`
    <style>
        .employer-form-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        .employer-form-container h2 {
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