import createView from "../createView.js";

export default function PostIndex(props) {
    return `
        <header>
            <h1>Posts Page</h1>
        </header>
        <main>
            <!--    MAKE CREATE FORM HERE    -->
            <div class="post-container">
                <form>
                    <input type="text" placeholder="Enter title" id="title">
                    <input type="text" placeholder="Enter content" id="content">
                    <button  id="btn-add" type="button">Add Post</button>
                </form>
                    ${props.posts.map(post => `
                <div class="post">
                    <h3 class="post-title" data-id=${post.id}>${post.title}</h3>
                    <h2>${post.content}</h2>
                    <!--   add edit, delete buttons, add edit form   -->
                    <button id="btn-edit" class="edit-post-btn">Edit</button>
                    <button id="btn-delete" class="delete-post-btn">Delete</button>
                </div>
                    `).join('')}
        
     
            </div>
        
        </main>
    `;
}

export function PostsEvent() {

    // call function for create button listener

    createPostEvent();


    // call function for edit button listener

    editEvent();

    // call function for delete button listener



}

function createPostEvent(){

    $("#btn-add").click(function () {

        let post = {
            title: $('#title').val(),
            content: $('#content').val()
        }

        let request = {
            method: "Post",
            headers: {"Content-Type":"application/json"},
            body: JSON.stringify(post)
        }

        fetch("http://localhost:8080/api/posts", request)
            .then(res => {
                console.log(res.status);
                createView("/posts")
            }).catch(error => {
            console.log(error);
            createView("/posts")
        });
    })
}

function editEvent(){

    $(".edit-post-btn").click(function () {

        console.log("edit event fired off");
        $(this).siblings(".edit-title, .edit-content").attr("contenteditable", true);
        $(this).text("Save");

    })



}