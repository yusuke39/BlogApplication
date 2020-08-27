<template>
  <div>
    <div class="tag-box">
      <i class="fas fa-tag"></i>
      <div class="tags">
        <router-link to="/tagArticles" class="tag-word">イヌ好き</router-link>
        <router-link to="/tagArticles" class="tag-word">ゴールデン</router-link>
      </div>
    </div>
  </div>
</template>

<style>
 .fa-tag {
    margin-top: 5px;
    color: #5F5B5B;
  }

  .tag-box {
    margin-top: 20px;
    margin-left: 40px;
    display: flex;
  }

  .tags {
    display: flex;
  }

  .tag-word {
    margin-left: 10px;
  }
</style>
