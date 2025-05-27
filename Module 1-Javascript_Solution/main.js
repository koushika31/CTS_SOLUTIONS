// Sample event data with images and updated categories
const events = [
  {
    name: "Music Fest",
    date: "2025-06-10",
    category: "musicfest",
    seats: 30,
    image: "images/musicfest.jpg"
  },
  {
    name: "Art Fair",
    date: "2025-06-15",
    category: "artfair",
    seats: 20,
    image: "images/artfair.jpg"
  },
  {
    name: "Food Carnival",
    date: "2025-07-01",
    category: "foodcarnival",
    seats: 100,
    image: "images/foodcarnival.jpg"
  },
  {
    name: "Yoga Day",
    date: "2025-06-25",
    category: "yogaday",
    seats: 50,
    image: "images/yogaday.jpg"
  },
  {
    name: "Tech Workshop",
    date: "2025-06-20",
    category: "techworkshop",
    seats: 25,
    image: "images/techworkshop.jpg"
  },
  {
    name: "Book Fest",
    date: "2025-07-05",
    category: "bookfest",
    seats: 60,
    image: "images/bookfest.jpg"
  },
];

// Fees by category
const fees = {
  musicfest: "$120",
  artfair: "$40",
  foodcarnival: "Free",
  yogaday: "$30",
  techworkshop: "$75",
  bookfest: "Free",
};

// DOM Elements
const eventsTableBody = document.querySelector("#eventsTable tbody");
const registrationForm = document.getElementById("registrationForm");
const eventTypeSelect = document.getElementById("eventType");
const eventFeeDiv = document.getElementById("eventFee");
const outputMsg = document.getElementById("outputMsg");

// --- Initialization ---
window.onload = function () {
  loadPreferences();
  displayEvents();
  alert("Welcome to the Community Portal");
};

// Show fees when event type changes
function showFee() {
  const type = eventTypeSelect.value;
  eventFeeDiv.textContent = type ? `Event Fee: ${fees[type] || "TBD"}` : "";
}

// Save preference for event type to localStorage
function savePreferences() {
  const type = eventTypeSelect.value;
  localStorage.setItem("eventType", type);
}

// Load preferences from localStorage
function loadPreferences() {
  const selectedType = localStorage.getItem("eventType");
  if (selectedType) {
    eventTypeSelect.value = selectedType;
    showFee();
  }
}

// Clear stored preferences
function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();
  alert("Preferences cleared.");
  eventFeeDiv.textContent = "";
  eventTypeSelect.value = "";
}

// Validate phone number (10 digits)
function validatePhone() {
  const phone = document.getElementById("phone").value.trim();
  if (!/^\d{10}$/.test(phone)) {
    alert("Enter a valid 10-digit phone number.");
    return false;
  }
  return true;
}

// Character count in feedback textarea
function countChars() {
  const text = document.getElementById("feedback").value;
  document.getElementById("charCount").innerText = `Characters: ${text.length}`;
}

// Show confirmation message on submission
function showConfirmation(message = "Thank you! Your registration is confirmed.") {
  outputMsg.textContent = message;
  outputMsg.style.color = "green";
}

// Enlarge event images on double-click
function enlargeImage(img) {
  if (img.classList.contains("enlarged")) {
    img.classList.remove("enlarged");
  } else {
    // Remove any other enlarged images
    document.querySelectorAll(".enlarged").forEach((el) => el.classList.remove("enlarged"));
    img.classList.add("enlarged");
  }
}

// Submit form handler
function submitRegistration(event) {
  event.preventDefault();

  // Validate phone number
  if (!validatePhone()) return;

  // Here you would normally send form data to a server or save it

  showConfirmation();
  registrationForm.reset();
  eventFeeDiv.textContent = "";
}

// Display events in the table (filter upcoming only)
function displayEvents() {
  eventsTableBody.innerHTML = "";

  const today = new Date();

  const upcomingEvents = events.filter((event) => {
    const eventDate = new Date(event.date);
    return eventDate >= today && event.seats > 0;
  });

  if (upcomingEvents.length === 0) {
    const tr = document.createElement("tr");
    const td = document.createElement("td");
    td.colSpan = 6;
    td.textContent = "No upcoming events available.";
    tr.appendChild(td);
    eventsTableBody.appendChild(tr);
    return;
  }

  upcomingEvents.forEach((event) => {
    const tr = document.createElement("tr");

    // Event Name
    const nameTd = document.createElement("td");
    nameTd.textContent = event.name;
    tr.appendChild(nameTd);

    // Date
    const dateTd = document.createElement("td");
    dateTd.textContent = event.date;
    tr.appendChild(dateTd);

    // Category (capitalize and spaces for readability)
    const catTd = document.createElement("td");
    catTd.textContent = prettifyCategory(event.category);
    tr.appendChild(catTd);

    // Seats available
    const seatsTd = document.createElement("td");
    seatsTd.textContent = event.seats;
    tr.appendChild(seatsTd);

    // Image with double-click enlarge
    const imgTd = document.createElement("td");
    const img = document.createElement("img");
    img.src = event.image;
    img.alt = event.name;
    img.className = "event-image";
    img.title = "Double-click to enlarge";
    img.ondblclick = () => enlargeImage(img);
    imgTd.appendChild(img);
    tr.appendChild(imgTd);

    // Register button
    const regTd = document.createElement("td");
    const regBtn = document.createElement("button");
    regBtn.textContent = "Register";
    regBtn.onclick = () => {
      // Auto-fill form
      eventTypeSelect.value = event.category;
      registrationForm.elements["date"].value = event.date;
      showFee();

      // Scroll to form
      registrationForm.scrollIntoView({ behavior: "smooth" });

      // Show message and focus on name input
      outputMsg.textContent = `You selected "${event.name}". Please complete the registration form below.`;
      outputMsg.style.color = "blue";
      registrationForm.elements["name"].focus();
    };
    regTd.appendChild(regBtn);
    tr.appendChild(regTd);

    eventsTableBody.appendChild(tr);
  });
}

function prettifyCategory(cat) {
  // convert camel case to words and capitalize words
  return cat
    .replace(/([a-z])([A-Z])/g, "$1 $2")
    .split(" ")
    .map((w) => w.charAt(0).toUpperCase() + w.slice(1))
    .join(" ");
}

// Video readiness indicator
function videoReady() {
  document.getElementById("videoStatus").textContent = "Video is ready to play!";
}

// Geolocation functionality
function findLocation() {
  const geoResult = document.getElementById("geoResult");

  if (!navigator.geolocation) {
    geoResult.textContent = "Geolocation is not supported by your browser.";
    return;
  }

  geoResult.textContent = "Locating...";

  navigator.geolocation.getCurrentPosition(
    (position) => {
      geoResult.textContent = `Latitude: ${position.coords.latitude.toFixed(
        4
      )}, Longitude: ${position.coords.longitude.toFixed(4)}`;
      // You could add logic here to find nearby events based on coordinates
    },
    () => {
      geoResult.textContent = "Unable to retrieve your location.";
    }
  );
}
