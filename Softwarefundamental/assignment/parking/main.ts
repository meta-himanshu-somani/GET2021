import  {Employee}  from "./Employee.js";
import {Vehicle} from './Vehicle.js';
var EmployeesDetails=[];
var form=<HTMLFormElement>document.getElementById('AddEmployee');
var empVehicleDetails={'Name':'modelName',
                        'Type':'vehicleType',
                        'Number':'vehicleNumber',
                        'EmpID':'EmpID',
                        'Identification':'mark'};
var empDetails={
    'ID':'1001',
    'name':'EmpName',
    'gender':'EmpGender',
    'email':'EmpMail',
    'password':'EmpPassword',
    'mobileNumber':123};
  
  // Display form to Register Employee

 //displayEmp(event);
 function displayEmp(event: { preventDefault: (arg0: number) => void; }){
    // let is new version of javascript-->Ecmascript
    let inputName = document.createElement('input');
    inputName.setAttribute('id',empDetails.name);
    inputName.setAttribute('type','text');
    inputName.setAttribute('name','empName');
    inputName.setAttribute('placeholder','What is your name');
    inputName.style.marginTop='20px';
    inputName.required=true;
    if(document.getElementById('EmpName')==null){
        form.appendChild(inputName);
        inputName.onfocus=(event) => {inputName.style.borderColor='green';};
        inputName.addEventListener('keypress',event => {
            if(event.key=='Enter'){
                if(inputName.value===''){
                    inputName.style.borderColor='red';
                    inputName.onfocus=(event) => {inputName.style.borderColor='red';};
                    event.preventDefault();
                    return false;
                }else{
                    empDetails.name=inputName.value;
                    inputName.onfocus=(event) => {inputName.style.borderColor='green';};
                    // Call gender function to display in form
                    inputGender(empDetails.name,event);
                    //increse the height of form when field added
                    form.style.maxHeight= form.scrollHeight+'px';
                    
                }
                }
            
            });
    }else{
        event.preventDefault(0);
            return false;
    }
    
    
}
// display gender field and call next field
function inputGender(empName: string,event: KeyboardEvent){
    if(
        document.getElementById('GenderLabel')==null && 
        document.getElementById('EmpGenderMale')==null &&
        document.getElementById('EmpGenderFemale')==null)
        {
            let label = document.createElement('label');
            label.setAttribute('id','GenderLabel');
            label.innerHTML='Hi, '+empName+' may I know your gender';
            let inputMale = document.createElement('input');
            inputMale.setAttribute('id','EmpGenderMale');
            inputMale.setAttribute('type','radio');
            inputMale.setAttribute('name','choice');
            inputMale.setAttribute('value','Male');
            let labelMale = document.createElement('label');
            labelMale.innerHTML='Male';
            labelMale.style.marginLeft='2px';
            labelMale.style.marginRight='2px';
            let inputFemale = document.createElement('input');
            inputFemale.setAttribute('id','EmpGenderFemale');
            inputFemale.setAttribute('type','radio');
            inputFemale.setAttribute('name','choice');
            inputFemale.setAttribute('value','Female');
            let labelFemale = document.createElement('label');
            labelFemale.innerHTML='Female';
            labelFemale.style.marginLeft='2px';
            labelFemale.style.marginRight='2px';
            let setBtn = document.createElement('button');
            setBtn.innerHTML='SET';
            setBtn.style.marginLeft='10px';
            form.append(document.createElement('br'))
            form.append(label);
            form.append(document.createElement('br'))
            form.append(inputMale);
            form.append(labelMale)
            form.append(inputFemale);
            form.append(labelFemale);
            form.append(setBtn);
            // on Set gender click will call email function
            setBtn.addEventListener('click',event => {
                if(inputFemale.checked) empDetails.gender= 'Female';
                if(inputMale.checked) empDetails.gender= 'Male';
                inputEmail(event);
                form.style.maxHeight= form.scrollHeight+'px';
            });
            event.preventDefault();
            return false;
        }
        else{
            event.preventDefault();
            return false;
        }
       
}
// display email field
function inputEmail(event: MouseEvent){
    let inputEmpEmail = document.createElement('input');
        inputEmpEmail.setAttribute('id','EmpEmail');
        inputEmpEmail.setAttribute('type','text');
        inputEmpEmail.setAttribute('name','Email');
        inputEmpEmail.setAttribute('placeholder','Your email');
        
    if(document.getElementById('EmpEmail')==null){
        form.append(document.createElement('br'));
        form.append(inputEmpEmail);
        // arrow function is used in ecmascript
        inputEmpEmail.addEventListener('keypress',event => {
            if(event.key=='Enter'){
                //check validity of email
                if(inputEmpEmail.value=='' || !inputEmpEmail.value.match(/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)){
                    inputEmpEmail.style.borderColor='red';
                    form.append(document.createElement('label').innerHTML='Enter valid email');
                }else{
                    empDetails.email=inputEmpEmail.value;
                    createPassword(event);
                    form.style.maxHeight= form.scrollHeight+'px';
                }
            }
        });
        event.preventDefault();
    }
    
    else{
        event.preventDefault();
        return false;   

    }  
    
}
// display password field
function createPassword(event: KeyboardEvent){
    var password = document.createElement('input');
    password.setAttribute('id','Password');
    password.setAttribute('type','password');
    password.setAttribute('name','empPassword');
    password.setAttribute('placeholder','Enter password');
    password.style.marginTop='20px';
    var cnfrmPassword = document.createElement('input');
    cnfrmPassword.setAttribute('id','cnfrmPassword');
    cnfrmPassword.setAttribute('type','password');
    cnfrmPassword.setAttribute('name','empCnfrmPassword');
    cnfrmPassword.setAttribute('placeholder','Enter password again');
    cnfrmPassword.style.marginTop='20px';
    var labelPass= document.createElement('label');
    labelPass.style.fontSize='12px';
    
    labelPass.innerHTML='Must contain special character,number,one capital';
    if(document.getElementById('Password')==null&&
    document.getElementById('cnfrmPassword')==null){
        form.append(document.createElement('br'));
        form.append(password);
        form.append(document.createElement('br'));
        form.append(labelPass);
        form.append(document.createElement('br'));
        form.append(cnfrmPassword);
        password.addEventListener('keypress',(event) => {
            if(event.key=='Enter'){
                //check validity of password
                if(password.value=='' || password.value.length<8 || 
                !(password.value.match(/[a-z]/g) &&  password.value.match(
                    /[A-Z]/g) &&  password.value.match(
                    /[0-9]/g) &&  password.value.match(
                    /[^a-zA-Z\d]/g))
                    ){
                    password.style.borderColor='red';
                    alert('1 uppercase , 1 lowercase, 1nmber, 1 special char and minimum 8 char');
                }
            }
        });
        cnfrmPassword.addEventListener('keypress',(event) => {
            if(event.key=='Enter'){
                if(password.value!=cnfrmPassword.value || cnfrmPassword.value==''){
                    alert('password does not match!');
                }
                else{
                    empDetails.password=password.value;
                    phoneNumber(event);
                    form.style.maxHeight= form.scrollHeight+'px';
                }
            }
        });
        event.preventDefault();
        return false;
    }else{
        event.preventDefault();
        return false;
    }
    
}
function phoneNumber(event: KeyboardEvent){
    var number = document.createElement('input');
    number.setAttribute('id','PhoneNumber');
    number.setAttribute('type','number');
    number.setAttribute('name','phoneNumber');
    number.setAttribute('placeholder','Contact number');
    number.style.marginTop='20px';
    number.style.marginLeft='20px';
    var labelNumber= document.createElement('label');
    labelNumber.style.fontSize='10px';
    if(document.getElementById('PhoneNumber')==null){
        form.append(document.createElement('br'));
        form.append(number);
        number.addEventListener('keypress',(event) => {
            if(event.key=='Enter'){
                if(number.value=='' || number.value.length!=10){
                    form.append(labelNumber.innerHTML='Number must be equal to 10');
                }else{
                    empDetails.mobileNumber=parseInt(number.value);
                    submitDetails(event);
                    form.style.maxHeight= form.scrollHeight+'px';
                }
            }
        });
    }
    else{
        event.preventDefault();
        return false;
    }
}
// submit detail and refresh page
function submitDetails(event: KeyboardEvent){
    var submit = document.createElement('button');
    submit.setAttribute('id','SubmitEmpForm');
    submit.setAttribute('type','submit');
    submit.setAttribute('name','submit');
    submit.style.marginTop='10px';
    submit.style.marginLeft='20px';
    submit.innerHTML="Submit"
    if(document.getElementById('SubmitEmpForm')==null){
        form.append(document.createElement('br'));
        form.append(submit);
        submit.addEventListener('click',(event) => {
            EmployeesDetails.push(empDetails);
            // when submit button clicked emp details added and show them in consol
            let emp1 = new Employee(empDetails);
            emp1.showDetails();
            alert('Your form is submitted');
            event.preventDefault();
            return false;
        });
    }else{
        event.preventDefault();
        return false;
    }
}
// active when vehicle form is clicked
// display filed one by one 
function addVehicle(event: { preventDefault: (arg0: number) => void; }){
    var name = <HTMLInputElement>document.getElementById('vehicleCompany');
    // check name of vehicle 
    name.addEventListener('keypress',(event) => {
        if(event.key=='Enter'){
            if(name.value.length>2){
                empVehicleDetails.Name=name.value;
                name.style.display='none';
                var labelType = <HTMLLabelElement>document.getElementById('type');
                labelType.style.display='';
                var inputType = <HTMLInputElement>document.getElementById('Type');
                inputType.style.display='';
                typeofVehicle(inputType,event);
                event.preventDefault();
                return false;
            }else{
                alert('name must greater than 2 char');
                event.preventDefault();
                return false;
            }
    }
    });
    event.preventDefault(0);
        return false;
}

function typeofVehicle(type: HTMLInputElement,event: KeyboardEvent){
    type.addEventListener('keypress',(event: { key: string; preventDefault: (arg0: number) => void; }) => {
        if(event.key=='Enter'){
            if(type.value.length>2 && (type.value.toUpperCase()=='CYCLE' || type.value.toUpperCase()=='MOTORCYCLE' || type.value.toUpperCase()=='FOURWHEELER')){
                empVehicleDetails.Type=type.value;
                let typeLabel = <HTMLLabelElement>document.getElementById('type');
                typeLabel.style.display='none';
                type.style.display='none';
                var labelVehicleNum =<HTMLLabelElement> document.getElementById('vehicleNumber');
                labelVehicleNum.style.display='';
                var inputVehicleNum = <HTMLInputElement>document.getElementById('VehicleNumber');
                inputVehicleNum.style.display='';
                vehicleNumber(inputVehicleNum,event);
                event.preventDefault(0);
                return false;
            }else{
                alert('type must greater than 2 char or enter correct vehicle type (cycle,motorcycle or fourwheeler)');
                event.preventDefault(0);
                return false;
            }
    }
    });
}

function vehicleNumber(number: HTMLInputElement,event: any){
    number.addEventListener('keypress',(event: { key: string; preventDefault: (arg0: number) => void; }) => {
        if(event.key=='Enter'){
            if(number.value!=''){
                empVehicleDetails.Number=number.value;
                (<HTMLLabelElement>document.getElementById('vehicleNumber')).style.display='none';
                number.style.display='none';
                var labelEmpID = <HTMLLabelElement>document.getElementById('empID');
                labelEmpID.style.display='';
                var inputEmpID = <HTMLInputElement>document.getElementById('EmpID');
                inputEmpID.style.display='';
                empID(inputEmpID,event);
                event.preventDefault(0);
                return false;
            }else{
                event.preventDefault(0);
                return false;
            }
    }
    });
}
function empID(ID: HTMLInputElement,event: any){
    ID.addEventListener('keypress',(event: { key: string; preventDefault: (arg0: number) => void; }) => {
        if(event.key=='Enter'){
            if(ID.value!=''){
                empVehicleDetails.EmpID=ID.value;
                (<HTMLLabelElement>document.getElementById('empID')).style.display='none';
                ID.style.display='none';
                var labelIdentity = <HTMLLabelElement>document.getElementById('identification');
                labelIdentity.style.display='';
                var inputIdentity = <HTMLInputElement>document.getElementById('Identification');
                inputIdentity.style.display='';
                empIdentification(inputIdentity,event);
                var vForm = <HTMLFormElement>document.getElementById('VehicleForm');
                vForm.style.maxHeight= vForm.scrollHeight+'px';
                event.preventDefault(0);
                return false;
            }else{
                event.preventDefault(0);
                return false;
            }
    }
    });
}

function empIdentification(identity: HTMLInputElement,event: any){
    identity.addEventListener('keypress',(event: { key: string; preventDefault: (arg0: number) => void; }) => {
        if(event.key=='Enter'){
            if(identity.value!=''){
                empVehicleDetails.Identification=identity.value;
                var submit = <HTMLButtonElement>document.getElementById('SubmitVehicle');
                submit.style.display='';
                submit.style.marginBottom='10px';
                submit.disabled=false;
                // put vehicle details and show details in consol
                let vehicle = new Vehicle(empVehicleDetails);
                vehicle.showDetails();
                var vForm = <HTMLFormElement>document.getElementById('VehicleForm');
                vForm.style.maxHeight= vForm.scrollHeight+'px';
                displayPricing(submit,event);
                event.preventDefault(0);
                return false;
            }else{
                event.preventDefault(0);
                return false;
            }
    }    
    });
}

function displayPricing(submit: HTMLButtonElement,event: { preventDefault: (arg0: number) => void; }){
    submit.addEventListener('click',(event: { preventDefault: (arg0: number) => void; })=>{
        (<HTMLLabelElement>document.getElementById('PriceHeader')).style.display='';
        let vehicleType =<HTMLInputElement>document.getElementById(empVehicleDetails.Type.toUpperCase());
        vehicleType.style.display='';
        event.preventDefault(0);
        return false;
    });
    event.preventDefault(0);
        return false;
       
}

function PurchaseNow(event: { preventDefault: (arg0: number) => void; }){
    
    let amount=<HTMLInputElement>document.getElementById('amount');
    amount.style.display='';
    let label = document.createElement('label');
    label.setAttribute('id','Price');
    (<HTMLBodyElement>document.querySelector('body')).append(label)
    if(amount.nodeValue==''){
        label.innerHTML='Enter valid amount in $';
    }else{
        event.preventDefault(0);
        return false;
    }

}

function dollerToYen(){
    let price = <HTMLInputElement>document.getElementById('amount');
    let lablePrice = <HTMLLabelElement>document.getElementById('Price');
    lablePrice.innerHTML = String(parseInt(price.value)*110.71) + ' YEN ';
}
(<HTMLButtonElement>document.getElementById('EmpAdd')).addEventListener("click",displayEmp,false);
(<HTMLButtonElement>document.getElementById('VehicleAdd')).addEventListener("click",addVehicle,false);
(<HTMLButtonElement>document.getElementsByClassName('Pricing-Buttons')[0]).addEventListener("click",PurchaseNow,false);
(<HTMLButtonElement>document.getElementsByClassName('Pricing-Buttons')[1]).addEventListener("click",PurchaseNow,false);
(<HTMLButtonElement>document.getElementsByClassName('Pricing-Buttons')[2]).addEventListener("click",PurchaseNow,false);
(<HTMLInputElement>document.getElementById('amount')).addEventListener('click',dollerToYen,false);