import createView from "../createView.js";

export default function User(props){

    return `
        <header>
        <h1>User information</h1>
        </header>
        
            
            ${props.user.map(post => `
                <form>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.id} aria-label="First name">
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.username} aria-label="First name">
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.email} aria-label="First name">
                        </div>
                    </div>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" placeholder="Password" aria-label="First name">
                        </div>
                    </div>
                    <button type="button" id="edit-btn">Edit</button>
                </form>
            `)}



    `
}


export function UserEvent(){

    $("#edit-btn").click(function () {

        console.log("edit event fired off!!");

        $().attr("contenteditable", false);
        $("#").text("Edit");

    })


}