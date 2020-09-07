<template>
  <div>
    <admin-header></admin-header>
    <el-card :body-style="{ padding: '0px' }"  class="admin-profile-box">
      <div>
        <img src="../assets/Bruins.jpg" class="admin-profile-img">
        <router-link to="/editAdmin">
          <el-button type="info" class="edit-profile-button">プロフィール設定</el-button>
        </router-link>
        <router-link to="/createArticle">
          <el-button type="success" class="create-article-button">記事を投稿する</el-button>
        </router-link>
      </div>
    </el-card>
    <el-card :body-style="{ padding: '0px' }"  class="search-box-wrapper">
      <div class="search-box">
        <form>
          <el-input
            id="blog-search"
            class="admintop-search"
            placeholder="ブログ検索"
            v-model="blogSearch">
            <i slot="prefix" class="el-input__icon el-icon-search"></i>
          </el-input>
          <el-select v-model="sortValue" placeholder="並び替え" id="category" class="search-category">
            <el-option
              v-for="sortOption in sortOptions"
              :key="sortOption.value"
              :label="sortOption.label"
              :value="sortOption.value">
            </el-option>
          </el-select>
          <el-button @click="resetForm()" class="reset-form-button">リセット</el-button>
        </form>
      </div>
    </el-card>
    <el-card :body-style="{ padding: '0px' }"  class="blog-list-box">
      <div class="sentence-box">
        <button
          @click="activeTab = 1"
          :class="[ activeTab === 1 ? 'active' : '']"
          class="tabBottan"
          >投稿記事</button>
        <button
          @click="activeTab = 2"
          :class="[ activeTab === 2 ? 'active' : '']"
          class="tabBottan"
          >いいねした記事</button>
        <button
          @click="activeTab = 3"
          :class="[ activeTab === 3 ? 'active' : '']"
          class="tabBottan"
          >保存した記事</button>
      </div>
      <hr>
      <div class="article-box" v-show="activeTab === 1">
        <span v-if="articles.length === 0">
          <p class="no-article">投稿された記事はありません</p>
        </span>
        <span v-for="(article, key) in articles" :key="key">
          <router-link to="/editArticle">
            <div class="blog-detail-box">
              <div class="blog-title">{{ article.articleTitle }}</div>
              <i class="far fa-heart"></i>
              <span>2</span>
              <span class="create-date">{{ article.createDate }}</span>
            </div>
          </router-link>
          <hr class="article-line">
        </span>
        <el-pagination
          class="admin-top-pagination"
          background
          layout="prev, pager, next"
          :total="1000">
        </el-pagination>
      </div>
      <div class="article-box" v-show="activeTab === 2">
        <router-link to="/editArticle">
          <div class="blog-detail-box">
            <div class="blog-title">いいねした記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <el-pagination
          class="admin-top-pagination"
          background
          layout="prev, pager, next"
          :total="1000">
        </el-pagination>
      </div>
      <div class="article-box" v-show="activeTab === 3">
        <router-link to="/editArticle">
          <div class="blog-detail-box">
            <div class="blog-title">保存した記事タイトル</div>
            <i class="far fa-heart"></i>
            <span>2</span>
            <span class="create-date">2020/8/8</span>
          </div>
        </router-link>
        <hr class="article-line">
        <el-pagination
          class="admin-top-pagination"
          background
          layout="prev, pager, next"
          :total="1000">
        </el-pagination>
      </div>
    </el-card>
    <el-card :body-style="{ padding: '0px' }"  class="graph-box">
      <doughnut class="doughnut-size"></doughnut>
      <lineGraph class="line-size"></lineGraph>
    </el-card>
  </div>
</template>

<script scoped>
import AdminHeader from './adminHeader'
import Doughnut from './doughnutGraph'
import LineGraph from './linegraph'
import axios from 'axios'
export default {
  data () {
    return {
      activeTab: 1,
      blogSearch: '',
      categoryValue: '',
      sortValue: '',
      articles: '',
      articleTitle: '',
      sortOptions: [{
        value: '1',
        label: '新しい投稿順'
      }, {
        value: '2',
        label: '古い投稿順'
      }, {
        value: '3',
        label: '公開されてる記事'
      }, {
        value: '4',
        label: '非公開されてる記事'
      }]
    }
  },
  mounted () {
    axios
      .get('http://localhost:8080/article/getCreateArticleInfo')
      .then(response => {
        this.articles = response.data
      })
      .catch(error => {
        console.log(error)
      })
  },
  methods: {
    resetForm () {
      this.blogSearch = ''
      this.categoryValue = ''
      this.sortValue = ''
    }
  },
  components: {
    'admin-header': AdminHeader,
    Doughnut,
    LineGraph
  }
}
</script>

<style scoped>
  .admin-profile-box {
    width: 300px;
    height: 300px;
    margin-left: 200px;
    margin-top: 50px;
  }

  .admin-profile-img {
    width: 100px;
    height: 100px;
    border-radius: 100%;
    position: relative;
    top: 30px;
    left: 100px;
  }

  .search-box-wrapper {
    width: 300px;
    height: 330px;
    margin-left: 200px;
    margin-top: 50px
  }

  .blog-list-box {
    width: 700px;
    height: auto;
    position: absolute;
    top: 470px;
    left: 550px;
    margin-bottom: 100px;
  }

  .edit-profile-button {
    color: #ffffff;
    width: 200px;
    position: relative;
    top: 60px;
    left: 50px;
  }

  .create-article-button {
    color: #ffffff;
    width: 200px;
    position: relative;
    top: 90px;
    left: 50px;
    background-color: #55C500;
  }

  .search-box {
    margin-left: 25px;
    margin-top: 40px;
  }

  .admintop-search {
    width: 250px;
    margin-bottom: 30px;
  }

  .search-category {
    width: 250px;
    margin-bottom: 30px;
  }

  .reset-form-button {
    background-color: #55C500;
    color: #ffffff;
    margin-left: 70px;
  }

  .sentence-box {
    margin-top: 30px;
    margin-left: 10px;
  }

  .ball {
    color: #55C500;
    margin-top: 30px;
  }

  .article-box {
    width: 600px;
    height: auto;
    margin-top: 30px;
    margin-left: 50px;
    padding: 10px 10px 20px 10px;
  }

  .blog-title {
    color: #5F5B5B;
    font-size: 25px;
    font-weight: bold;
  }

  .article-line {
    margin-bottom: 50px;
  }

  .admin-top-pagination {
    margin-left: 80px;
    margin-bottom: 20px;
  }

  a {
    text-decoration: none;
    color: #5F5B5B;
  }

  .blog-detail-box {
    margin-left: 40px;
  }

  .fa-heart {
    color: red;
  }

  .create-date {
    margin-left: 400px;
  }

  .doughnut-size {
    width: 300px;
    height: 300px;
  }

  .graph-box {
    position: absolute;
    top: 118px;
    left: 550px;
    width: 700px;
    height: 320px;
  }

  .line-size {
    width: 300px;
    height: 300px;
    position: absolute;
    top: 15px;
    left: 330px;
  }

  .tabBottan {
    font-weight: bold;
    margin-right: 10px;
    width: 130px;
    height: 50px;
    outline: 0;
  }

  .no-article {
    color: #5F5B5B;
    font-weight: bold;
    font-size: 20px;
    text-align: center;
    margin-bottom: 30px;
  }

  .active {
    background-color: #dddddd;
  }
</style>
