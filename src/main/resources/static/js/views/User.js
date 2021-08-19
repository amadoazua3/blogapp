import createView from "../createView.js";

export default function User(props){

    return `
        <header>
        <h1>User information</h1>
        </header>
        <main>
            
            ${props.users.map(user => `
                <form>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.id}>${user.id}</input>
                        </div>
                         <button type="button" class="edit-btn" data-id=${user.id}>Edit</button>
                    </div>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.username}>${user.username}</input>
                        </div>
                         <button type="button" class="edit-btn" data-id=${user.username}>Edit</button>
                    </div>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.email}>${user.email}</input>
                        </div>
                         <button type="button" class="edit-btn " data-id=${user.email}>Edit</button>
                    </div>
                    <div class="row g-3">
                        <div class="col">
                            <input type="text" class="form-control" data-id=${user.password}>${user.password}</input>
                        </div>
                         <button type="button" class="edit-btn" data-id=${user.password}>Edit</button>
                    </div>
                   
                </form>
            `).join('')}
        </main>
    `;
}


export function UserEvent(){

    // $(".edit-btn").click(function () {
    //
    //     console.log("edit event fired off!!");
    //
    //     $("").attr("contenteditable", false);
    //     $(".edit-btn").text("Edit");
    //
    // })


}