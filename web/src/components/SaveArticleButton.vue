<template>
  <div>
    <link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
    <i
      class="far fa-bookmark"
      @click="clickBookMark"
      :class="{ 'bookmark-color' : isSave }"
      ></i>
  </div>
</template>

<script>
export default {
  data () {
    return {
      saveArticle: '',
      isSave: false
    }
  },
  methods: {
    clickBookMark () {
      if (this.isSave) {
        this.isSave = false
      } else {
        this.isSave = true
      }
    }
  }
}
</script>

<style>
  .fa-bookmark {
    font-size: 20px;
    margin-left: 20px;
    color: #5F5B5B;
  }

  .bookmark-color {
    color: #0026ff;
  }
</style>
