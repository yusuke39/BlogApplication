<template>
  <div>
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <i
      class="far fa-heart"
      @click="clickHeart"
      :class="{ 'heart-red' : isActive }"
      ></i>
      <span class="count">{{ goodArticleCount }}</span>
  </div>
</template>

<script>
export default {
  data () {
    return {
      goodArticleCount: 0,
      isActive: false
    }
  },
  methods: {
    clickHeart () {
      if (this.isActive) {
        this.goodArticleCount = this.goodArticleCount - 1
        this.isActive = false
      } else {
        this.goodArticleCount = this.goodArticleCount + 1
        this.isActive = true
      }
    }
  }
}
</script>

<style>
  .fa-heart {
    font-size: 20px;
    margin-left: 35px;
    color: #5F5B5B;
  }

   .count {
    color: #5F5B5B;
  }

  .heart-red {
    color: red;
  }
</style>
