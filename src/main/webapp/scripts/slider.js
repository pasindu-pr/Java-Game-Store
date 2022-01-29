const indicators = document.querySelectorAll(".slider .indicators .indicator");
const arrowPrev = document.querySelector(".slider .arrows .arrow-prev");
const arrowNext = document.querySelector(".slider .arrows .arrow-next");

const handleIndicatorClick = (event) => {
  const indicator = event.target;
  // Returns true or false
  if (!isActive(indicator)) {
    removeActive();
    addActive(indicator);
    showSlide(indicator.dataset.slide);
  }
};


const handlePrevArrowClick = (event) => {
  let activeSlide = 0;
  let newActiveSlide = indicators.length;
  let ready = false;

  indicators.forEach((indicator) => {
    if (isActive(indicator) && !ready) {
      activeSlide = indicator.dataset.slide;
      if (activeSlide !== "1") {
        // If this is one we cant substract 1
        newActiveSlide = parseInt(activeSlide) - 1;
      }
      removeActive();
      addActive(
        document.querySelector(
          `.slider .indicators [data-slide='${newActiveSlide}']`
        )
      );
      showSlide(newActiveSlide);
      ready = true;
    }
  });
};


const handleNextArrowClick = (event) => {
  let activeSlide = 0;
  let newActiveSlide = 1;
  let ready = false;

  indicators.forEach((indicator) => {
	
	//To first check which is the active slide
    if (isActive(indicator) && !ready) {
      activeSlide = indicator.dataset.slide;
      if (activeSlide !== indicators.length.toString()) {
        newActiveSlide = parseInt(activeSlide) + 1;
      }
      removeActive();
      addActive(
        document.querySelector(
          `.slider .indicators [data-slide='${newActiveSlide}']`
        )
      );
      showSlide(newActiveSlide);
      ready = true;
    }
  });
};



arrowPrev.addEventListener("click", handlePrevArrowClick);
arrowNext.addEventListener("click", handleNextArrowClick);


//To check if the slide has active tag., If so return true
const isActive = (indicator) => {
  return indicator.hasAttribute("active");
};


//Find and remove the current active attribute
const removeActive = () => {
  document.querySelectorAll(".slider .indicators [active]").forEach((item) => {
    item.removeAttribute("active");
  });
};

//Add active attribute
const addActive = (indicator) => {
  indicator.setAttribute("active", "");
};

//Set add margin to the slide
const showSlide = (newActiveSlide) => {
  const newPosition = (100 * (newActiveSlide - 1)).toString();
  document.querySelector(".slider-inner").style.marginLeft = `-${newPosition}%`;
};

setInterval(() => {
  handleNextArrowClick();
}, 6000);
