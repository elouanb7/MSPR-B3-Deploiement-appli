<script setup>
</script>

<template>
  <main>
    <div class="box">
        <div class="background"></div>

        <div class="hometitle">
            <h1>Nom</h1>
            <h2>demande de garde</h2>
        </div>

        <input type="radio" id="image1" name="image" checked>
        <input type="radio" id="image2" name="image">
        <input type="radio" id="image3" name="image">

        <div class="container">
            <div class="featured-wrapper">
                <ul class="featured-list">
                    <li>
                        <figure>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/unsplash_nature4.jpg" alt="">
                        </figure>
                    </li>
                    <li>
                        <figure>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/unsplash_nature11.jpg" alt="">
                        </figure>
                    </li>
                    <li>
                        <figure>
                        <img src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/unsplash_nature6.jpg" alt="">
                        </figure>
                    </li>
                </ul>
                <ul class="arrows">
                    <li>
                        <label for="image1"></label>
                    </li>
                    <li>
                        <label for="image2"></label>
                    </li>
                    <li>
                        <label for="image3"></label>
                    </li>
                </ul>
                <ul class="dots">
                    <li>
                        <label for="image1"></label>
                    </li>
                    <li>
                        <label for="image2"></label>
                    </li>
                    <li>
                        <label for="image3"></label>
                    </li>
                </ul>
            </div>
        </div>

        <a href="">
            <button class="import-image">Importer une photo</button>
        </a>
        
        <div class="infos">
            <h3>Description</h3>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Erat quis imperdiet sodales egestas. Neque suspendisse sed accumsan, molestie aliquet.</p>

            <h3>Localisation</h3>
            <p>Lorem ipsum</p>

            <h3>Horaires</h3>
            <p>Lorem ipsum</p>
        </div>
    </div>
  </main>
</template>

<style>
.box {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.background {
  position: relative;
  max-width: 422px;
  width: 100%;
  height: 422px;
  background: #C5FFDC;
  filter: blur(125px);
  opacity: 0.25;
}

.hometitle {
  position: absolute;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  margin-top: 175px;
}

.import-image {
    width: 210px;
    height: 60px;
    background: #060825;
    box-shadow: 0px 15px 35px rgba(6, 8, 37, 0.2);
    border-radius: 30px;
    font-weight: 500;
    font-size: 16px;
    line-height: 20px;
    text-align: center;
    color: #FAFAFA;
    cursor: pointer;
    margin: 15px;
}

.infos {
    max-width: 458px;
    width: 100%;
}

h3 {
    font-weight: 400;
    font-size: 18px;
    line-height: 27px;
    color: #171616;
    margin-top: 15px;
}

p {
    font-weight: 400;
    font-size: 16px;
    line-height: 24px;
    color: #515151;
    border-bottom: 1px solid #3D3B36;
    padding-bottom: 15px;
    margin-top: 15px;
}

:root {
  --white: #fff;
  --red: #e74c3c;
  --black: #000;
  --img-color: #ededed;
  --overlay: rgba(0, 0, 0, 0.75);
}

* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

ul {
  list-style: none;
}

img {
  display: block;
  max-width: 100%;
  height: auto;
  background-color: var(--img-color);
}

label {
  display: block;
  cursor: pointer;
}

a {
  text-decoration: none;
  color: inherit;
}

input[type="radio"] {
  position: absolute;
  bottom: 0;
  left: -9999px;
}

body {
  color: var(--white);
  margin: 20px 0;
  font-family: sans-serif;
}

.container {
  max-width: 450px;
  padding: 0 20px;
  margin: 0 auto;
}

/* SLIDESHOW
–––––––––––––––––––––––––––––––––––––––––––––––––– */
.featured-wrapper {
  position: relative;
}

.featured-wrapper .featured-list {
  display: grid;
}

.featured-wrapper .featured-list li {
  grid-column: 1;
  grid-row: 1;
  opacity: 0;
  transition: opacity 0.25s;
}

.featured-wrapper .arrows label::before,
.featured-wrapper .arrows label::after {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  width: 40px;
  height: 40px;
  border-radius: 50%;
  color: var(--black);
  background-position: center;
  background-repeat: no-repeat;
  background-size: 24px 24px;
  background-color: var(--white);
  opacity: 0.5;
  transition: opacity 0.25s;
}

.featured-wrapper .arrows label::before {
  top: -120px;
  left: 10px;
}

.featured-wrapper .arrows label::after {
  top: -120px;
  right: 10px;
}

.featured-wrapper .dots {
  position: absolute;
  bottom: 10px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
}

.featured-wrapper .dots li:not(:last-child) {
  margin-right: 8px;
}

.featured-wrapper .dots label {
  display: inline-block;
  width: 12px;
  height: 12px;
  border-radius: 50%;
  border: 1px solid var(--white);
  transition: background 0.25s;
}

.featured-wrapper .dots label:hover {
  background: currentColor;
}

.thumb-list {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-column-gap: 20px;
  margin-top: 20px;
}

.thumb-list label {
  display: grid;
}

.thumb-list img,
.thumb-list .outer {
  grid-column: 1;
  grid-row: 1;
}

.thumb-list .outer {
  display: grid;
  place-items: center;
  transition: background 0.25s;
}

.thumb-list .inner {
  font-size: 18px;
  opacity: 0;
  transform: translateY(20px);
  transition: all 0.25s;
}

/* MIMIC CLICK EVENT
–––––––––––––––––––––––––––––––––––––––––––––––––– */
[id="image1"]:checked ~ .container .featured-list li:nth-child(1),
[id="image2"]:checked ~ .container .featured-list li:nth-child(2),
[id="image3"]:checked ~ .container .featured-list li:nth-child(3),
[id^="image"]:checked ~ .container .arrows [for^="image"]:hover::before,
[id^="image"]:checked ~ .container .arrows [for^="image"]:hover::after {
  opacity: 1;
}

[id="image1"]:checked ~ .container .arrows [for="image3"]::before,
[id="image2"]:checked ~ .container .arrows [for="image1"]::before,
[id="image3"]:checked ~ .container .arrows [for="image2"]::before {
  content: '';
  background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/arrow-prev-slideshow.svg);
}

[id="image1"]:checked ~ .container .arrows [for="image2"]::after,
[id="image2"]:checked ~ .container .arrows [for="image3"]::after,
[id="image3"]:checked ~ .container .arrows [for="image1"]::after {
  content: '';
  background-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/162656/arrow-next-slideshow.svg);
}

[id="image1"]:checked ~ .container .dots [for="image1"],
[id="image2"]:checked ~ .container .dots [for="image2"],
[id="image3"]:checked ~ .container .dots [for="image3"] {
  background: currentColor;
}

[id="image1"]:checked ~ .container [for="image1"] .outer,
[id="image2"]:checked ~ .container [for="image2"] .outer,
[id="image3"]:checked ~ .container [for="image3"] .outer {
  background: var(--overlay);
}

[id="image1"]:checked ~ .container [for="image1"] .inner,
[id="image2"]:checked ~ .container [for="image2"] .inner,
[id="image3"]:checked ~ .container [for="image3"] .inner {
  opacity: 1;
  transform: none;
}
</style>