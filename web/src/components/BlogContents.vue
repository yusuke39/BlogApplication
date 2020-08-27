<template>
  <div>
    <h2>ブログ記事タイトル</h2>
    <p class="blog-create-time">2020/8/15 20:00:00</p>
    <img src="../assets/Bruins.jpg" class="blog-content-img">
    <pre class="blog-content">
      ブログの内容がここに入りますよーーー
      ブログの内容がここに入りますよーーー

      ブログの内容がここに入りますよーーー
      ブログの内容がここに入りますよーーー

      ブログの内容がここに入りますよーーー

      ブログの内容がここに入りますよーーー
      <Tags/>
    </pre>
  </div>
</template>

<script>
import Tags from './Tags'
export default {
  components: {
    Tags
  }
}
</script>

<style>
  .blog-create-time {
    color: #5F5B5B;
    margin-bottom: 30px;
  }

  .blog-content-img {
    width: 300px;
    height: 300px;
    margin-bottom: 20px;
  }

  .blog-line {
    margin-top: 30px;
    margin-bottom: 30px;
  }
</style>
