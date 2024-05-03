// Fetch problem data and populate cards
fetch("/problems")
    .then(response => response.json())
    .then(data => {
        const problemList = document.getElementById("problemList");
        for (const [filename, tags] of Object.entries(data)) {
            const card = createCard(filename, tags);
            problemList.appendChild(card);
        }
    })
    .catch(error => console.error("Error fetching data:", error));

// Function to create a card element
function createCard(filename, tags) {
    const card = document.createElement("div");
    card.classList.add("col", "mb-3");

    const cardInner = document.createElement("div");
    cardInner.classList.add("card", "h-100");
    cardInner.addEventListener("click", () => openFile(filename));

    const cardBody = document.createElement("div");
    cardBody.classList.add("card-body");

    const cardTitle = document.createElement("h5");
    cardTitle.classList.add("card-title");
    cardTitle.textContent = filename; // Display only filename without extension

    const cardText = document.createElement("p");
    cardText.classList.add("card-text");
    cardText.textContent = tags.join(", ");

    cardBody.appendChild(cardTitle);
    cardBody.appendChild(cardText);

    cardInner.appendChild(cardBody);
    card.appendChild(cardInner);

    return card;
}

// Search functionality
const tagInput = document.getElementById("tagInput");
tagInput.addEventListener("input", function () {
    const filter = this.value.toLowerCase();
    const cards = document.getElementsByClassName("card");
    for (let card of cards) {
        const tags = card.querySelector(".card-text").textContent.toLowerCase();
        if (tags.includes(filter)) {
            card.style.display = "block";
        } else {
            card.style.display = "none";
        }
    }
});

// Open file function (replace with your actual implementation)
function openFile(filename) {
    console.log("Opening file:", filename);
    // Replace with your logic to open the file in a new window or redirect
    // Example:
    window.open("/problems/" + filename, "_blank");
}
