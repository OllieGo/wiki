<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <p>
        <a-form layout="inline" :model="param">
          <a-form-item>
            <a-input v-model:value="param.name" placeholder="名称">
            </a-input>
          </a-form-item>
          <a-form-item>
            <a-button type="primary" @click="handleQuery({pageNum: 1, pageSize: pagination.pageSize})">
              查询
            </a-button>
          </a-form-item>
          <a-form-item>
            <a-button type="primary" @click="add()">
              新增
            </a-button>
          </a-form-item>
        </a-form>
      </p>
      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="categorys"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #cover="{ text: cover }">
          <img v-if="cover" :src="cover" alt="avatar" style="width: 60px;"/>
        </template>
        <!--<template v-slot:category="{ text, record }">
          <span>{{ getCategoryName(record.category1Id) }} / {{ getCategoryName(record.category2Id) }}</span>
        </template>-->
        <template v-slot:action="{ text, record }">
          <a-space size="small">
            <!--<router-link :to="'/admin/doc?categoryId=' + record.id">
              <a-button type="primary">
                文档管理
              </a-button>
            </router-link>-->
            <a-button type="primary" @click="edit(record)">
              编辑
            </a-button>
            <a-popconfirm
                title="删除后不可恢复，确认删除?"
                ok-text="是"
                cancel-text="否"
                @confirm="handleDelete(record.id)"
            >
              <a-button type="danger">
                删除
              </a-button>
            </a-popconfirm>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>

  <a-modal
      title="分类表单"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
  >
    <a-form :model="category" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="名称">
        <a-input v-model:value="category.name"/>
      </a-form-item>
      <a-form-item label="父分类">
        <a-input v-model:value="category.parent"/>
      </a-form-item>
      <a-form-item label="顺序">
        <a-input v-model:value="category.sort"/>
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from 'axios';
import {Tool} from "@/util/tool";
import {message} from 'ant-design-vue';

export default defineComponent({
  name: 'AdminCategory',
  setup() {
    const param = ref();
    param.value = {};
    const categorys = ref();
    const pagination = ref({
      current: 1,
      pageSize: 10,
      total: 0
    });
    const loading = ref(false);

    const columns = [
      {
        title: '名称',
        dataIndex: 'name'
      },
      {
        title: '父分类',
        dataIndex: 'parent'
      },
      {
        title: '顺序',
        dataIndex: 'sort'
      },
      {
        title: 'Action',
        key: 'action',
        slots: {customRender: 'action'}
      }
    ];

    /**
     * 数据查询
     **/
    const handleQuery = (params: any) => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      categorys.value = [];
      let data = {
        'pageNum': params.pageNum,
        'pageSize': params.pageSize,
        'name': param.value.name
      }

      axios.post("/category/page",
          data
      ).then((response) => {
        loading.value = false;
        const data = response.data;
        console.log("data");
        console.log(data);
        if (data.code == 1) {
          categorys.value = data.data.list;

          // 重置分页按钮
          pagination.value.current = params.pageNum;
          pagination.value.total = data.data.totalSize;
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * 表格点击页码时触发
     */
    const handleTableChange = (pagination: any) => {
      console.log("看看自带的分页参数都有啥：" + pagination);
      handleQuery({
        pageNum: pagination.current,
        pageSize: pagination.pageSize
      });
    };

    // -------- 表单 ---------
    //const categoryIds = ref();
    const category = ref();
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => {
      modalLoading.value = true;
      //category.value.categoryOneId = categoryIds.value[0];
      //category.value.categoryTwoId = categoryIds.value[1];
      axios.post("/category/save", category.value).then((response) => {
        modalLoading.value = false;
        const data = response.data;
        if (data.code == 1) {
          modalVisible.value = false;
          // 重新加载列表
          handleQuery({
            pageNum: pagination.value.current,
            pageSize: pagination.value.pageSize,
          });
        } else {
          message.error(data.message);
        }
      });
    };

    /**
     * 编辑
     */
    /*const edit = (record: any) => {
      modalVisible.value = true;
      category.value = Tool.copy(record);
      categoryIds.value = [category.value.category1Id, category.value.category2Id]
    };*/

    const edit = (record: any) => {
      modalVisible.value = true;
      category.value = Tool.copy(record);
    };

    /**
     * 新增
     */
    const add = () => {
      modalVisible.value = true;
      category.value = {};
    };

    const handleDelete = (id: number) => {
      axios.delete("/category/delete/" + id).then((response) => {
        const data = response.data;
        if (data.code == 1) {
          // 重新加载列表
          handleQuery({
            pageNum: pagination.value.current,
            pageSize: pagination.value.pageSize,
          });
        } else {
          message.error(data.message);
        }
      });
    };

    onMounted(() => {
      handleQuery({
        pageNum: 1,
        pageSize: pagination.value.pageSize
      });
    });

    return {
      param,
      categorys,
      pagination,
      columns,
      loading,
      handleTableChange,
      handleQuery,

      edit,
      add,

      category,
      modalVisible,
      modalLoading,
      handleModalOk,
      handleDelete
    }
  }
});


</script>