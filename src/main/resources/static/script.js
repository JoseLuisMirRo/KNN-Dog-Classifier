const token = localStorage.getItem('dogClassification');
 
 // Función para cargar el archivo Excel
 async function processExcel() {
    const fileInput = document.getElementById("fileInput");
    const file = fileInput.files[0];

    if (!file) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Por favor, selecciona un archivo.',
        confirmButtonColor: '#f27474',
          scrollbarPadding: false
      });
      return;
    }

    const formData = new FormData();
    formData.append("file", file);

    try {
      const response = await fetch("/api/dataset/upload", {
        method: "POST",
        body: formData,
      });

      if (response.ok) {
        const data = await response.json();
        Swal.fire
        ({
          icon: 'success',
          title: 'Archivo cargado',
          text: data.message || "Archivo cargado correctamente",
          confirmButtonColor: '#da9d48',
        });
        const modal = bootstrap.Modal.getInstance(document.getElementById("uploadModal"));
        modal.hide();
      } else {
        throw new Error("Error al cargar el archivo.");
      }
    } catch (error) {
      console.error("Error:", error);
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'Hubo un problema al cargar el archivo.',
        confirmButtonColor: '#f27474',
      })
    }
  }

  async function submitSpecs() {
    const height = parseFloat(document.getElementById('height').value);
    const weight = parseFloat(document.getElementById('weight').value);
    const coatLength = parseFloat(document.getElementById('coatLength').value);
    const color = parseInt(document.getElementById('color').value);
    const activityLevel = parseInt(document.getElementById('activityLevel').value, 10);
    const friendliness = parseInt(document.getElementById('friendliness').value, 10);
    const intelligence = parseInt(document.getElementById('intelligence').value, 10);

    if (isNaN(height) || isNaN(coatLength) || isNaN(weight) || isNaN(activityLevel) || isNaN(friendliness) || isNaN(intelligence)) {
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Por favor, completa todos los campos correctamente.',
            confirmButtonColor: '#f27474',
          });
        return;
    }

    const dogData = {
        height,
        weight,
        coatLength,
        color,
        activityLevel,
        friendliness,
        intelligence
    };

    try {
        const response = await fetch("/api/dogs/classify", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dogData)
        });

        const data = await response.json();
        console.log("Respuesta del backend:", JSON.stringify(data, null, 2));

        // Guardar los datos en localStorage
        localStorage.setItem('dogClassification', JSON.stringify(data.data));
        console.log("Datos guardados en localStorage:", data.data);

        // Redirigir a la página final.html
        window.location.href = `/final.html`;
        console.log(response)

        if (response.ok) {
            /*const breed = data.data.breed;
            const imageURL = data.data.imageURL;

            // Guardar la respuesta en el localStorage
            localStorage.setItem('dogClassification', JSON.stringify(data.data));
            console.log("Datos guardados en localStorage:", data.data);

            // Redirigir a la página final.html
            localStorage.setItem('dogClassification', JSON.stringify(data.data));
            window.location.href = `http://127.0.0.1:5500/final.html`;*/
            
        } else {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Hubo un error al clasificar la raza del perro.',
                confirmButtonColor: '#f27474',
              });
        }
    } catch (error) {
        console.error("Error en la solicitud:", error);
        Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Hubo un error al conectar con la API.',
            confirmButtonColor: '#f27474',
          });
    }
}

// Función para cargar y mostrar los datos en final.html
function loadDogClassification() {
  const dogDataString = localStorage.getItem('dogClassification');
  if (!dogDataString) {
      console.error("No se encontraron datos de clasificación en localStorage.");
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No hay datos disponibles para mostrar.',
        confirmButtonColor: '#f27474',
      });
      return;
  }

  const dogData = JSON.parse(dogDataString);
  console.log("Datos recuperados de localStorage:", dogData);

  // Mostrar datos en el DOM
  const breedElement = document.getElementById("breed");
  const imageElement = document.getElementById("dogImage");

  if (breedElement && imageElement) {
      breedElement.textContent = dogData.breed || "Raza desconocida";
      imageElement.src = dogData.imageURL || "placeholder.jpg";
  } else {
      console.error("Elementos DOM no encontrados para mostrar datos.");
  }
}

// Detectar en qué página estamos y ejecutar la lógica adecuada
document.addEventListener("DOMContentLoaded", () => {
  if (document.getElementById("submitButton")) {
      // Si estamos en index.html, enlazar el evento al botón de enviar
      document.getElementById("submitButton").addEventListener("click", submitSpecs);
  }

  if (document.getElementById("breed") && document.getElementById("dogImage")) {
      // Si estamos en final.html, cargar los datos de clasificación
      loadDogClassification();
  }
});

document.addEventListener("DOMContentLoaded", () => {
  // Obtener los datos almacenados
  const dogDataString = localStorage.getItem('dogClassification');
  
  if (!dogDataString && window.location.pathname === "/final.html") {
      console.error("No se encontraron datos de clasificación en localStorage.");
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'No hay datos disponibles para mostrar.',
        confirmButtonColor: '#f27474',
      });
      return;
  }

  // Parsear los datos y mostrarlos en la página
  const dogData = JSON.parse(dogDataString);
  console.log("Datos recuperados de localStorage:", dogData);

  // Aquí puedes manipular el DOM para mostrar los datos
  const breedElement = document.getElementById("breed");
  const imageElement = document.getElementById("dogImage");
  const heightElement = document.getElementById("height");
  const weightElement = document.getElementById("weight");
  const coatLengthElement = document.getElementById("coatLength");
  const colorElement = document.getElementById("color");
  const friendlinessElement = document.getElementById("friendliness");
  const activityLevelElement = document.getElementById("activityLevel");
  const intelligenceElement = document.getElementById("intelligence");

  const colorMap = {
    1: "Negro",
    2: "Blanco",
    3: "Beige",
    4: "Chocolate",
    5: "Gris",
    6: "Dorado",
    7: "Manchado",
    8: "Mixtos o raros"
  };

  breedElement.textContent = dogData.breed || "Raza desconocida";
  imageElement.src = dogData.imageURL || "placeholder.jpg";
  heightElement.textContent = (dogData.height + " cm") || "Tamaño desconocido";
  weightElement.textContent = (dogData.weight + " kg") || "Peso desconocido";
  coatLengthElement.textContent = (dogData.coatLength + " cm") || "Largo desconocido";
  const colorValue = dogData.color;
  const colorText = colorMap[colorValue] || "Color desconocido";
  // Mostrar el texto en el elemento
  colorElement.textContent = colorText;
  friendlinessElement.textContent = (dogData.friendliness ) || "amistad desconocida";
  activityLevelElement.textContent = (dogData.activityLevel) || "actividad desconocida";
  intelligenceElement.textContent = (dogData.intelligence) || "inteligencia desconocida";

});
// Validación nativa de Bootstrap
document.addEventListener("DOMContentLoaded", () => {
  if (document.getElementById("submitButton")) {
    // Si estamos en index.html, enlazar el evento al botón de enviar
    document.getElementById("submitButton").addEventListener("click", submitSpecs);
  }

  if (document.getElementById("breed") && document.getElementById("dogImage")) {
    // Si estamos en final.html, cargar los datos de clasificación
    loadDogClassification();
  }

  // Validación nativa de Bootstrap
  const form = document.getElementById("dogSpecsForm");
  if (form) {
    form.addEventListener("submit", async (event) => {
      event.preventDefault();
      event.stopPropagation();

      if (form.checkValidity()) {
        await submitSpecs();
      }
      form.classList.add("was-validated");
    });

    // Validación en tiempo real
    const inputs = form.querySelectorAll("input, select");
    inputs.forEach((input) => {
      input.addEventListener("input", () => {
        if (input.checkValidity()) {
          input.classList.remove("is-invalid");
          input.classList.add("is-valid");
        } else {
          input.classList.remove("is-valid");
          input.classList.add("is-invalid");
        }
      });
    });
  }
});

const back = () => {
    window.location.href = `/index.html`;
    localStorage.removeItem('dogClassification');
}