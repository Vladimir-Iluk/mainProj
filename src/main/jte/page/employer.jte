@import com.iluk.git.mainProj.data.Entitys.Employer
@import java.util.List
@param List<Employer> empls
@param String sortDirection
@param String searchTerm

@template.layout.main(
content = @`
    <div class="container">
        <h2>Employers List</h2>
        <a href="/employer/add" class="btn-add">Add New Employer</a>
        <div class="sort-container">
            <span class="sort-label">Sort by ID:</span>
            <a href="/employer?sort=${sortDirection == "asc" ? "desc" : "asc"}" class="btn-sort">
                ${sortDirection == "asc" ? "▼ Descending" : "▲ Ascending"}
            </a>

        </div>
        <div class="search-container">
            <form action="/employer" method="get">
                <input type="text" name="search" placeholder="Search across all fields..."
                       value="${searchTerm != null ? searchTerm : ""}">
                <button type="submit" class="btn-search">Search</button>
                <a href="/employer" class="btn-clear">Clear</a>
            </form>
        </div>
        <table class="data-table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Last Name</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Qualification</th>
                <th>Expected Salary</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            @for(Employer employer : empls)
                <tr>
                    <td>${employer.getEmployerId()}</td>
                    <td>${employer.getLastName()}</td>
                    <td>${employer.getFirstName()}</td>
                    <td>${employer.getMiddleName()}</td>
                    <td>${employer.getQualification()}</td>
                    <td>${employer.getExpectedSalary()}</td>
                    <td>
                        <a href="/employer/edit?id=${employer.getEmployerId()}" class="btn-edit">Edit</a>
                        <a href="/employer/delete?id=${employer.getEmployerId()}" class="btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            @endfor
            </tbody>
        </table>
    </div>
`,
headContent = @`
    <style>
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .btn-add {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            margin-bottom: 20px;
            text-decoration: none;
            border-radius: 4px;
        }

        .sort-container {
            margin-bottom: 15px;
            display: flex;
            align-items: center;
        }

        .sort-label {
            margin-right: 10px;
            font-weight: bold;
        }

        .btn-sort {
            display: inline-block;
            background-color: #6c757d;
            color: white;
            padding: 8px 12px;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .btn-sort:hover {
            background-color: #5a6268;
        }

        .data-table {
            width: 100%;
            border-collapse: collapse;
        }

        .data-table th, .data-table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .data-table th {
            background-color: #f2f2f2;
        }

        .data-table tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .btn-edit {
            display: inline-block;
            background-color: #2196F3;
            color: white;
            padding: 5px 10px;
            text-decoration: none;
            border-radius: 4px;
        }
        .btn-delete {
            display: inline-block;
            background-color: #f44336;
            color: white;
            padding: 5px 10px;
            margin-left: 5px;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn-delete:hover {
            background-color: #d32f2f;
        }
        .search-container {
            margin-bottom: 20px;
            display: flex;
        }

        .search-container input[type="text"] {
            padding: 8px;
            width: 300px;
            border: 1px solid #ddd;
            border-radius: 4px 0 0 4px;
        }

        .btn-search {
            padding: 8px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 0 4px 4px 0;
            cursor: pointer;
        }

        .btn-clear {
            padding: 8px 15px;
            margin-left: 10px;
            background-color: #f44336;
            color: white;
            text-decoration: none;
            border-radius: 4px;
        }

        .btn-search:hover {
            background-color: #45a049;
        }

        .btn-clear:hover {
            background-color: #d32f2f;
        }
    </style>
`
)