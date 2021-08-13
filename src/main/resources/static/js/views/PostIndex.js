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
<!--                <input type="text" placeholder="Enter id" class="newPost" id="input-id">-->
                <input type="text" placeholder="Enter title" class="newPost" id="input-title">
                <input type="text" placeholder="Enter content" class="newPost" id="input-content">
                <button  id="btn-add">Add</button>
                ${props.posts.map(post => `
                    <h3 class="post-title" data-id=${post.id}>${post.title}</h3>
                    <h2>${post.content}</h2>
                    <!--   add edit, delete buttons, add edit form   -->
                    <button id="btn-edit">Edit</button>
                    <button id="btn-delete">Delete</button>
                                        `).join('')}   
              
                </form>
            </div>
    
                
                    
        </main>
    `;
}

export function PostsEvent() {

    // call function for create button listener

    // var postObj = {};
    // var addListener = function (event) {
    //
    //     const id = document.getElementById("input-id").value;
    //     const title = document.getElementById("input-title").value;
    //     const content = document.getElementById("input-content").value;
    //
    //     postObj = {id, title, content};
    //     console.log(postObj);
    //
    // };
    //
    // document.getElementById('btn-add').addEventListener('click', addListener);

    createPostEvent();


    // call function for edit button listener

    var editListener = function (event){

    }

    document.getElementById('btn-edit').addEventListener('click', editListener);

    // call function for delete button listener

    var deleteListener = function (event){

    }

    document.getElementById('btn-delete').addEventListener('click', deleteListener);

}

function createPostEvent(){

    $("#btn-add").click(function () {

        let post = {
            title: $('#input-title').val(),
            content: $('#input-content').val()
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