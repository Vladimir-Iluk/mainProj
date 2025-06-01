@import com.iluk.git.mainProj.data.Entitys.Companie
@param Companie companie

@template.layout.main(
content = @`
    <div class="company-form-container">
        <h2>Edit Company</h2>
        <form action="/companie/edit" method="post" class="company-form">
            <input type="hidden" name="id" value="${companie.getCompanyId()}">

            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" value="${companie.getName()}" required class="form-control">
            </div>

            <div class="form-group">
                <label for="activityType">Activity Type:</label>
                <input type="text" id="activityType" name="activityType" value="${companie.getActivityType()}" class="form-control">
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" id="address" name="address" value="${companie.getAddress()}" class="form-control">
            </div>

            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="${companie.getPhone()}" class="form-control">
            </div>

            <button type="submit" class="btn-submit">Update Company</button>
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