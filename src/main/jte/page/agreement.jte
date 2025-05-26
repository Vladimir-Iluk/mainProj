@import com.iluk.git.mainProj.data.Agreement
@import java.util.List
@param List<Agreement> agreementsList
@template.layout.main(content = @`
    <ul>
        @for(Agreement agreement: agreementsList)
            <li>
                <div class="companie">
                    <p>First name employer - ${agreement.getEmpl().getFirstName()}</p>
                    <p>Last name employer - ${agreement.getEmpl().getLastName()}</p>
                    <p>Middle name employer - ${agreement.getEmpl().getMiddleName()}</p>
                    <p>Qualification employer - ${agreement.getEmpl().getQualification()}</p>
                    <p>Activity employer - ${agreement.getEmpl().getActivityType()}</p>
                    <p>==================================</p>
                    <p>Company name - ${agreement.getCompany().getName()}</p>
                    <p>Company activity - ${agreement.getCompany().getActivityType()}</p>
                    <p>Company address - ${agreement.getCompany().getAddress()}</p>
                    <p>Company phone - ${agreement.getCompany().getPhone()}</p>
                    <p>Agreement position - ${agreement.getPosition()}</p>
                    <p>Agreement commision - ${agreement.getCommission()}</p>

                </div>
            </li>
        @endfor
    </ul>

`)