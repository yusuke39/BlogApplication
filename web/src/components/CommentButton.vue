<template>
  <div>
    <router-link to="/blogDetail">
      <i class="far fa-comment"></i>
      <span class="count">{{ commentCount }}</span>
    </router-link>
  </div>
</template>

<script>
export default {
  data () {
    return {
      commentCount: 0
    }
  }
}
</script>

<style>
  .fa-comment {
    font-size: 20px;
    margin-left: 20px;
    color: #5F5B5B;
  }
</style>
